package local.nio.heartbeat;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HeartBeatClient {

    private Bootstrap bootstrap = null;
    private Channel channel = null;
    private int port = -1;

    public HeartBeatClient(int port) {
        this.port = port;
    }

    @SneakyThrows
    public void connect() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChildChannelHandler());
        doConnect();
    }

    public void request() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            if (channel != null && channel.isActive()) {
                ByteBuf buffer = channel.alloc().buffer();
                buffer.writeByte(HeartBeatHandler.BIZ_TYPE);
                buffer.writeBytes(("request data #" + i).getBytes());
                channel.writeAndFlush(buffer);
                System.out.println("client request");
            }
            Thread.sleep((random.nextInt(3) + 4) * 1000);
        }
    }

    public void close() {
        channel.close();
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        private static final int MAX_FRAME_LENGTH = 1024 * 10;

        @Override
        protected void initChannel(SocketChannel ch) {
            ChannelPipeline pipeline = ch.pipeline();
            pipeline.addLast(new IdleStateHandler(0, 0, 3));
            pipeline.addLast(new LengthFieldPrepender(2));
            pipeline.addLast(new LengthFieldBasedFrameDecoder(MAX_FRAME_LENGTH, 0, 2, 0, 2));
            pipeline.addLast(new ClientHeartBeatHandler());
        }
    }


    private class ClientHeartBeatHandler extends HeartBeatHandler {
        @Override
        protected void handleBizData(ChannelHandlerContext ctx, ByteBuf msg) {
            msg.skipBytes(1);
            byte[] data = new byte[msg.readableBytes()];
            msg.readBytes(data);
            System.out.println(String.format("received data {%s} from server ", new String(data)));
        }

        @Override
        protected void handleAllIdle(ChannelHandlerContext ctx) {
            System.out.println("client has a all idle");
            ByteBuf buffer = ctx.alloc().buffer(1);
            buffer.writeByte(PING_TYPE);
            buffer.retain();
            ctx.writeAndFlush(buffer);
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            super.channelInactive(ctx);
            System.out.println("channel inactive, try reconnecting");
            HeartBeatClient.this.doConnect();
        }
    }

    private void doConnect() {
        if (channel != null && channel.isActive()) {
            return;
        }
        ChannelFuture future = bootstrap.connect("127.0.0.1", port);
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    channel = future.channel();
                    System.out.println("connect successfully");
                } else {
                    System.out.println("connect failed, try again in 5 sec");
                    future.channel().eventLoop().schedule(() -> doConnect(), 5, TimeUnit.SECONDS);
                }
            }
        });
    }
}
