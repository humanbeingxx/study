package local.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2019-06-12
 **/
public class NIOTimeClient implements Runnable {

    private int port;
    private Selector selector;
    private SocketChannel channel;
    private volatile boolean stop;

    public NIOTimeClient(int port) {
        this.port = port;
        try {
            selector = Selector.open();
            channel = SocketChannel.open();
            channel.configureBlocking(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        try {
            doConnect();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        while (!stop) {
            try {
                selector.select(500);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (!key.isValid()) {
            return;
        }
        SocketChannel channel = (SocketChannel) key.channel();
        if (key.isConnectable()) {
            if (channel.finishConnect()) {
                channel.register(selector, SelectionKey.OP_READ);
                doWrite(channel);
            } else {
                throw new RuntimeException("connect failed");
            }
        } else if (key.isReadable()) {
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int readBytes = channel.read(readBuffer);
            if (readBytes > 0) {
                readBuffer.flip();
                byte[] bytes = new byte[readBuffer.remaining()];
                readBuffer.get(bytes);
                String body = new String(bytes, StandardCharsets.UTF_8);
                System.out.println(body);
                stop = true;
            } else if (readBytes < 0) {
                key.cancel();
                channel.close();
            }
        }
    }

    private void doConnect() throws IOException {
        if (channel.connect(new InetSocketAddress(port))) {
            channel.register(selector, SelectionKey.OP_READ);
            doWrite(channel);
        } else {
            channel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel channel) throws IOException {
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        writeBuffer.put("query time order".getBytes());
        writeBuffer.flip();
        channel.write(writeBuffer);
        if (!writeBuffer.hasRemaining()) {
            System.out.println("send to server successfully");
        }
    }
}
