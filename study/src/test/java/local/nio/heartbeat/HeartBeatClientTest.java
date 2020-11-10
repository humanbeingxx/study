package local.nio.heartbeat;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HeartBeatClientTest {

    @Test
    public void testConnect() throws InterruptedException {
        HeartBeatClient client1 = new HeartBeatClient(8989);
        HeartBeatClient client2 = new HeartBeatClient(8989);
        new Thread(new Runnable() {
            @Override
            public void run() {
                client1.connect();
                client2.connect();
            }
        }).start();

        Thread.sleep(1000);

        client1.request();
        client2.request();

        Thread.sleep(5000);
    }

    @Test
    public void testChannel() throws Exception {
        new HeartBeatClient(8989).connect();
        new HeartBeatClient(8989).connect();
        new HeartBeatClient(8989).connect();
        Thread.sleep(3000);
    }
}