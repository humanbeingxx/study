package local.nio.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.AttributeKey;
import lombok.SneakyThrows;

public class HeartBeatServer {
    private static final AttributeKey<Object> TEST_ATTR = AttributeKey.valueOf("testAttr");

    @SneakyThrows
    public void start(int port) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());
            ChannelFuture future = serverBootstrap.bind(port);
            ChannelFuture sync = future.sync();
            sync.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        private static final int MAX_FRAME_LENGTH = 1024 * 10;

        @Override
        protected void initChannel(SocketChannel ch) {
            Object attr = new Object();
            ch.attr(TEST_ATTR).set(attr);
            System.out.println("set attr " + System.identityHashCode(attr) + " for channel " + System.identityHashCode(ch));
            ChannelPipeline pipeline = ch.pipeline();
            pipeline.addLast(new IdleStateHandler(5, 0, 0));
            pipeline.addLast(new LengthFieldPrepender(2));
            pipeline.addLast(new LengthFieldBasedFrameDecoder(MAX_FRAME_LENGTH, 0, 2, 0, 2));
            pipeline.addLast(new ServerHeartBeatHandler());
        }
    }

    private static class ServerHeartBeatHandler extends HeartBeatHandler {

        private static final byte[] RESPONSE_MSG_CONTENT = "data received...".getBytes();

        @Override
        protected void handleBizData(ChannelHandlerContext ctx, ByteBuf msg) {
            Object attr = ctx.attr(TEST_ATTR).get();
            System.out.println("get attr " + System.identityHashCode(attr) + " from channel " + System.identityHashCode(ctx.channel()));
            ByteBuf byteBuf = ctx.channel().alloc().buffer();
            byteBuf.writeByte(BIZ_TYPE);
            byteBuf.writeBytes(RESPONSE_MSG_CONTENT);
            byteBuf.retain();
            ctx.writeAndFlush(byteBuf);
            msg.skipBytes(1);
            byte[] data = new byte[msg.readableBytes()];
            msg.readBytes(data);
            System.out.println("server handle biz data { " + new String(data) + " } from " + ctx.channel().remoteAddress());
        }

        @Override
        protected void handleReadIdle(ChannelHandlerContext ctx) {
            System.out.println("server has a read idle with " + ctx.channel().remoteAddress());
            ctx.close();
        }
    }
}
