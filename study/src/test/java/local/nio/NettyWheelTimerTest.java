package local.nio;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NettyWheelTimerTest {

    @Test
    public void test() throws InterruptedException {
        HashedWheelTimer timer = new HashedWheelTimer();
        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws InterruptedException {
                System.out.println("run task1 @" + System.currentTimeMillis());
                Thread.sleep(2000);
            }
        }, 100, TimeUnit.MILLISECONDS);
        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws InterruptedException {
                System.out.println("run task2 @" + System.currentTimeMillis());
            }
        }, 200, TimeUnit.MILLISECONDS);
        Thread.sleep(50000);
    }
}
