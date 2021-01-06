package local.nio.heartbeat;

import org.testng.annotations.Test;

public class HeartBeatServerTest {

    @Test
    public void testStart() {
        new HeartBeatServer().start(8989);
    }
}