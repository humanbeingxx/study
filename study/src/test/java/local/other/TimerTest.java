package local.other;

import org.testng.annotations.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTest {

    @Test
    public void test() throws InterruptedException {
        Timer timer = new Timer();
        System.out.println("task schedule @ " + System.currentTimeMillis());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task run @ " + System.currentTimeMillis());
            }
        }, 1000);
        Thread.sleep(2000);
    }

    @Test
    public void testPool() throws InterruptedException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        threadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("task run @ " + System.currentTimeMillis());
            }
        }, 1, TimeUnit.SECONDS);
        Thread.sleep(2000);

    }
}
