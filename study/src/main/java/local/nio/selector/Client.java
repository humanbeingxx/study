package local.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/10 15:51
 */
public class Client {

    public void work(int port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", port));

        socketChannel.close();
    }
}
