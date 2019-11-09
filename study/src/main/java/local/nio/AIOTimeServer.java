package local.nio;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author cuixiaoshuang
 * @date 2019-06-12
 **/
public class AIOTimeServer implements Runnable {

    private AsynchronousServerSocketChannel channel;

    private CountDownLatch running;

    public AIOTimeServer(int port) {
        try {
            channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        running = new CountDownLatch(1);
        try {
            channel.accept(this, new AcceptCompletedHandler());
            running.await();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private class AcceptCompletedHandler implements CompletionHandler<AsynchronousSocketChannel, AIOTimeServer> {

        @Override
        public void completed(AsynchronousSocketChannel result, AIOTimeServer attachment) {
            attachment.channel.accept(attachment, this);
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            result.read(readBuffer, readBuffer, new ReadCompletedHandler(result));
        }

        @Override
        public void failed(Throwable exc, AIOTimeServer attachment) {
            exc.printStackTrace();
            running.countDown();
        }
    }

    private class ReadCompletedHandler implements CompletionHandler<Integer, ByteBuffer> {

        private AsynchronousSocketChannel channel;

        ReadCompletedHandler(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            attachment.flip();
            byte[] bytes = new byte[attachment.remaining()];
            attachment.get(bytes);
            String request = new String(bytes, StandardCharsets.UTF_8);
            System.out.println("server received: " + request);
            String currentTime = request.equalsIgnoreCase("query time order") ? new Date().toString() : "BAD REQUEST";
            doWrite(currentTime);
        }

        private void doWrite(String response) {
            if (StringUtils.isNotBlank(response)) {
                byte[] bytes = response.getBytes();
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                writeBuffer.put(bytes);
                writeBuffer.flip();
                channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        if (attachment.hasRemaining()) {
                            channel.write(attachment, attachment, this);
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        exc.printStackTrace();
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            exc.printStackTrace();
            try {
                this.channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
