package local.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * @author cuixiaoshuang
 * @date 2019-06-12
 **/
public class AIOTimeClient implements Runnable, CompletionHandler<Void, AIOTimeClient> {

    private int port;
    private AsynchronousSocketChannel channel;
    private CountDownLatch running;

    public AIOTimeClient(int port) {
        try {
            this.port = port;
            channel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try (AsynchronousSocketChannel ch = this.channel) {
            running = new CountDownLatch(1);
            ch.connect(new InetSocketAddress(port), this, this);
            running.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void completed(Void result, AIOTimeClient attachment) {
        byte[] request = "query time order".getBytes(StandardCharsets.UTF_8);
        ByteBuffer writeBuffer = ByteBuffer.allocate(request.length);
        writeBuffer.put(request);
        writeBuffer.flip();
        channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer buffer) {
                if (buffer.hasRemaining()) {
                    channel.write(buffer, buffer, this);
                } else {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    channel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            byte[] bytes = new byte[attachment.remaining()];
                            attachment.get(bytes);
                            String response = new String(bytes);
                            System.out.println(response);
                            running.countDown();
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
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
                try {
                    exc.printStackTrace();
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    running
                            .countDown();
                }
            }
        });

    }

    @Override
    public void failed(Throwable exc, AIOTimeClient attachment) {
        try {
            exc.printStackTrace();
            channel.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            running.countDown();
        }
    }
}
