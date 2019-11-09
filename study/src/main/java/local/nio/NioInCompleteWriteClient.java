package local.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2019-07-16
 **/
public class NioInCompleteWriteClient implements Runnable {

    private int port;
    private Selector selector;
    private SocketChannel channel;
    private volatile boolean stop;

    public NioInCompleteWriteClient(int port) {
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
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ByteBuffer writeBuffer = ByteBuffer.wrap("123456789!".getBytes());
                while (writeBuffer.hasRemaining()) {
                    try {
                        channel.write(writeBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}
