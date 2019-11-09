package local.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedFile;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static io.netty.channel.ChannelFutureListener.CLOSE;
import static io.netty.handler.codec.http.HttpHeaderUtil.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaderUtil.setContentLength;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static org.apache.http.HttpHeaders.*;

/**
 * @author cuixiaoshuang
 * @date 2019-06-18
 **/
public class NettyFileServer {

    static String url = "/Users/cxs/work/github/study";

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
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                            ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65535));
                            ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                            ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler());
                        }
                    });
            ChannelFuture future = serverBootstrap.bind("127.0.0.1", port).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

        @Override
        protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
            if (!request.decoderResult().isSuccess()) {
                sendError(ctx, BAD_REQUEST);
            }
            if (request.method() != GET) {
                sendError(ctx, METHOD_NOT_ALLOWED);
            }
            String uri = request.uri();
            String path = extractPath(uri);
            if (path == null) {
                sendError(ctx, NOT_FOUND);
                return;
            }
            File file = new File(path);
            if (file.isDirectory()) {
                if (uri.endsWith("/")) {
                    sendListing(ctx, file);
                } else {
                    sendRedirect(ctx, uri + '/');
                }
                return;
            }
            if (!file.isFile()) {
                sendError(ctx, FORBIDDEN);
                return;
            }
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                sendError(ctx, NOT_FOUND);
                return;
            }
            long fileLength = randomAccessFile.length();
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
            setContentLength(response, fileLength);
            setResponseFileContentType(response, file);

            if (isKeepAlive(request)) {
                response.headers().set(CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            }
            ctx.writeAndFlush(response);
            ChannelFuture sendFileFuture = ctx.write(new ChunkedFile(randomAccessFile, 0, fileLength, 8192),
                    ctx.newProgressivePromise());
            sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
                @Override
                public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) {
                    System.out.println(String.format("Transfer %d/%d", progress, total));
                }

                @Override
                public void operationComplete(ChannelProgressiveFuture future) {
                    System.out.println("Transfer completed");
                }
            });
            ChannelFuture lastContentFuture = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
            if (!isKeepAlive(request)) {
                lastContentFuture.addListener(CLOSE);
            }
            sendError(ctx, NOT_IMPLEMENTED);
        }

        private void setResponseFileContentType(DefaultFullHttpResponse response, File file) {
            MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
            response.headers().set("content-type", mimetypesFileTypeMap.getContentType(file.getPath()));
        }

        private void sendRedirect(ChannelHandlerContext ctx, String uri) {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, FOUND);
            response.headers().set(LOCATION, uri);
            ctx.writeAndFlush(response).addListener(CLOSE);
        }

        private void sendListing(ChannelHandlerContext ctx, File dir) {
            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
            response.headers().set(CONTENT_TYPE, "text/html; charset=UTF-8");
            StringBuilder buf = new StringBuilder();
            String dirPath = dir.getPath();
            buf.append("<!DOCTYPE html>\r\n");
            buf.append("<html><head><title>");
            buf.append(dirPath);
            buf.append(" 目录：");
            buf.append("</title></head><body>\r\n");
            buf.append("<h3>");
            buf.append(dirPath).append(" 目录：");
            buf.append("</h3>\r\n");
            buf.append("<ul>");
            // 此处打印了一个 .. 的链接
            buf.append("<li>链接：<a href=\"../\">..</a></li>\r\n");
            // 用于展示根目录下的所有文件和文件夹，同时使用超链接标识
            for (File f : dir.listFiles()) {
                if (f.isHidden() || !f.canRead()) {
                    continue;
                }
                String name = f.getName();
                buf.append("<li>链接：<a href=\"");
                buf.append(name);
                buf.append("\">");
                buf.append(name);
                buf.append("</a></li>\r\n");
            }
            buf.append("</ul></body></html>\r\n");
            ByteBuf buffer = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
            response.content().writeBytes(buffer);
            buffer.release();
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }

        private String extractPath(String uri) {
            try {
                URLDecoder.decode(uri, "utf8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("only support utf8");
            }
            if (!uri.startsWith(url)) {
                return null;
            }
            uri = uri.replace(url, "");
            return System.getProperty("user.dir") + File.separator + uri.replace("/", File.separator);
        }

        private void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, FOUND,
                    Unpooled.copiedBuffer(("Failure: " + status.toString() + "\r\n").getBytes()));
            ctx.writeAndFlush(response).addListener(CLOSE);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            if (ctx.channel().isActive()) {
                sendError(ctx, INTERNAL_SERVER_ERROR);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyFileServer().run(9990);
    }
}
