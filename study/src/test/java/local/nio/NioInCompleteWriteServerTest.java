package local.nio;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-07-16
 **/
public class NioInCompleteWriteServerTest {

    @Test
    public void test() throws Exception {
        NioInCompleteWriteServer server = new NioInCompleteWriteServer(9020);
        new Thread(server).start();
        NioInCompleteWriteClient client = new NioInCompleteWriteClient(9020);
        new Thread(client).start();

        Thread.sleep(1000);
    }

}