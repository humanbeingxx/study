package local.nio.heartbeat;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HeartBeatServerTest {

    @Test
    public void testStart() {
        new HeartBeatServer().start(8989);
    }
}