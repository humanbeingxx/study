package local.jcore;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueTest {

    @SneakyThrows
    @Test
    public void testOfferFull() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        queue.offer(1);
        queue.offer(1);

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                queue.offer(3, 100, TimeUnit.SECONDS);
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                queue.offer(2, 100, TimeUnit.SECONDS);
            }
        }).start();

        Thread.sleep(100);
        queue.take();
        Thread.sleep(100);
        System.out.println(queue);
    }
}
