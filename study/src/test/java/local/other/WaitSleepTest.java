package local.other;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class WaitSleepTest {

    @SneakyThrows
    @Test
    public void test() {
        Object lock = new Object();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("before wait");
                    lock.wait(1000);
                    System.out.println("after wait");
                }
            }
        }).start();

        Thread.sleep(10);

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("before notify");
                    Thread.sleep(300);
                    lock.notify();
                    System.out.println("after notify");
                }
            }
        }).start();

        Thread.sleep(500);
    }

}
