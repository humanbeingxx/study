package local.nio;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cuixiaoshuang
 * @date 2019-06-14
 **/
public class NettyTimeClient {
    private byte[] request = ("query time order" + System.getProperty("line.separator")).getBytes();
    private AtomicInteger requestCount = new AtomicInteger();

    public void connect(int port) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(new InetSocketAddress("127.0.0.1", port)).sync();
            request(future.channel());
            while (requestCount.get() != 0) {
            }
            System.out.println(String.format("port is %s", future.channel().localAddress()));
            future.channel().close();
        } finally {
            group.shutdownGracefully();
        }
    }

    private void request(Channel channel) {
        /*
          用多线程同时发送请求，即使server端用LineBasedFrameDecoder解析，也会出现报文错位的问题：
              1. server received: before before before before before query time order
              2. server received: query time order
              3. server received: query time order
              4. server received: query time order
              5. server received: query time order
          因为使用decoder并不能保证报文段并发发送的问题。
          如果客户端在channel上加上同步，server会不会有问题？本地测试没问题，但是如果考虑到网络传输延迟，
          会不会后发的数据先到？tcp的保证顺序有没有用？
          */

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                requestCount.incrementAndGet();
                ByteBuf preBuf = Unpooled.buffer(7);
                preBuf.writeBytes("before ".getBytes());
                synchronized (channel) {
                    channel.writeAndFlush(preBuf);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    ByteBuf requestBuf = Unpooled.buffer(request.length);
                    requestBuf.writeBytes(request);
                    channel.writeAndFlush(requestBuf);
                }

            }).start();
        }
    }

    private class TimeClientHandler extends ChannelHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            String response = String.valueOf(msg);
            System.out.println("client received: " + response);
            requestCount.decrementAndGet();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            System.out.println("error in client");
            cause.printStackTrace();
            ctx.close();
        }
    }
}
