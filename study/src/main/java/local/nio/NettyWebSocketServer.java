package local.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

import static io.netty.channel.ChannelFutureListener.CLOSE;
import static io.netty.handler.codec.http.HttpHeaderUtil.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaderUtil.setContentLength;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static org.apache.http.HttpHeaders.UPGRADE;

/**
 * @author cuixiaoshuang
 * @date 2019-06-14
 **/
public class NettyWebSocketServer {

    private AtomicInteger count = new AtomicInteger();

    public void run(int port) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-codec", new HttpServerCodec());
                            ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65535));
                            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                            ch.pipeline().addLast("handler", new WebSocketServerHandler());
                        }
                    });
            ChannelFuture future = serverBootstrap.bind("127.0.0.1", port).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

        private WebSocketServerHandshaker handshaker;

        @Override
        protected void messageReceived(ChannelHandlerContext ctx, Object msg) {
            if (msg instanceof FullHttpRequest) {
                handleHttp(ctx, (FullHttpRequest) msg);
            } else if (msg instanceof WebSocketFrame) {
                handleWebSocket(ctx, (WebSocketFrame) msg);
            }
        }

        private void handleHttp(ChannelHandlerContext ctx, FullHttpRequest request) {
            if (!request.decoderResult().isSuccess()
                    || !HttpHeaderValues.WEBSOCKET.equalsIgnoreCase(String.valueOf(request.headers().get(UPGRADE)))) {
                sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HTTP_1_1, BAD_REQUEST));
                return;
            }
            WebSocketServerHandshakerFactory handshakerFactory = new WebSocketServerHandshakerFactory("ws://127.0.0.1:9898/websocket", null, false);
            handshaker = handshakerFactory.newHandshaker(request);
            if (handshaker == null) {
                WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
            } else {
                handshaker.handshake(ctx.channel(), request);
            }
        }

        private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest request, DefaultFullHttpResponse response) {
            if (response.status().code() != 200) {
                ByteBuf byteBuf = Unpooled.copiedBuffer(response.status().toString(), Charset.defaultCharset());
                response.content().writeBytes(byteBuf);
                byteBuf.release();
                setContentLength(response, response.content().readableBytes());
            }
            ChannelFuture channelFuture = ctx.channel().writeAndFlush(response);
            if (!isKeepAlive(request) || response.status().code() != 200) {
                channelFuture.addListener(CLOSE);
            }
        }

        private void handleWebSocket(final ChannelHandlerContext ctx, WebSocketFrame frame) {
            System.out.println("handle ws");
            if (frame instanceof CloseWebSocketFrame) {
                handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
                return;
            }
            if (frame instanceof PingWebSocketFrame) {
                ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
                return;
            }
            if (!(frame instanceof TextWebSocketFrame)) {
                throw new UnsupportedOperationException("invalid socket frame : " + frame.getClass().getName());
            }
            String text = ((TextWebSocketFrame) frame).text();
            System.out.println(text);
            ctx.channel().writeAndFlush(new TextWebSocketFrame(text + ", Welcome, ready to send"));
            for (int i = 0; i < 5; i++) {
                ctx.channel().writeAndFlush(new TextWebSocketFrame(text + ", Welcome, count:" + count.getAndIncrement()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("message sent");
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.flush();
        }


        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyWebSocketServer().run(9898);
    }
}
