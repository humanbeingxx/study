package local.other;

import com.google.common.util.concurrent.RateLimiter;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @date 2019-05-07
 **/
public class RateLimiterTest {

    @Test
    public void testUse() throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(1);

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                double acquire = rateLimiter.acquire();
                System.out.println("wait for " + acquire);
            }).start();
        }

        Thread.sleep(10000);
    }

    @Test
    public void testTryAcquire() throws Exception {
        RateLimiter rateLimiter = RateLimiter.create(1);

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                boolean acquire = rateLimiter.tryAcquire(500, TimeUnit.MILLISECONDS);
                System.out.println("wait for " + acquire);
            }).start();
        }

        Thread.sleep(10000);
    }
}
