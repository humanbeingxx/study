package local.nio;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-06-12
 **/
public class AIOTimeServerTest {

    @Test
    public void test() throws InterruptedException {
        AIOTimeServer server = new AIOTimeServer(9999);
        new Thread(server).start();


        for (int i = 0; i < 5; i++) {
            Thread.sleep(800);
            new Thread(new AIOTimeClient(9999)).start();
        }

        Thread.sleep(5000);
    }
}
