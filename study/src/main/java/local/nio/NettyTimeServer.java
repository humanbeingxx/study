package local.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.concurrent.ExecutorServiceFactory;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static io.netty.channel.ChannelFutureListener.CLOSE;

/**
 * @author cuixiaoshuang
 * @date 2019-06-14
 **/
public class NettyTimeServer {

    public void bind(int port) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(2, new ExecutorServiceFactory() {
            @Override
            public ExecutorService newExecutorService(int parallelism) {
                return Executors.newFixedThreadPool(parallelism, new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "boss" + new Random().nextInt(100));
                    }
                });
            }
        });
        NioEventLoopGroup workGroup = new NioEventLoopGroup(2);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());
            ChannelFuture bind = serverBootstrap.bind("127.0.0.1", port);
            ChannelFuture future = bind.sync();
//            for (int i = 0; i < 1000; i++) {
//                Thread.sleep(1000);
//                System.out.println("do sth else");
//            }
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) {
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }

    private class TimeServerHandler extends ChannelHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            String request = String.valueOf(msg);
            System.out.println("server received: " + request);
            System.out.println("current thread: " + Thread.currentThread().toString());
            String response = request.replace("before ", "").equalsIgnoreCase("query time order") ? new Date().toString() : "BAD REQUEST";
            response += System.getProperty("line.separator");
            ByteBuf writeBuffer = Unpooled.copiedBuffer(response.getBytes());
            ctx.write(writeBuffer);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            System.out.println("error in server");
            cause.printStackTrace();
            ctx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyTimeServer().bind(9999);
    }
}
