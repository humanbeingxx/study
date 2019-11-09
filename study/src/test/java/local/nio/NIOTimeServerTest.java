package local.nio;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-06-12
 **/
public class NIOTimeServerTest {

    @Test
    public void test() throws InterruptedException {
        NIOTimeServer server = new NIOTimeServer(8080);
        new Thread(server).start();

        for (int i = 0; i < 5; i++) {
            NIOTimeClient client = new NIOTimeClient(8080);
            new Thread(client).start();
            Thread.sleep(1000);
        }

        Thread.sleep(6000);
    }
}