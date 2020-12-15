package local.jcore;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class NotifyOrderTest {

    private final Object lock = new Object();

    @Test
    public void testOrder() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is waiting");
                    synchronized (lock) {
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " get the lock");
                }
            }).start();
            Thread.sleep(20);
        }

        for (int i = 0; i < 50; i++) {
            synchronized (lock) {
                lock.notify();
            }
            Thread.sleep(10);
        }
        Thread.sleep(2000);
    }
}
