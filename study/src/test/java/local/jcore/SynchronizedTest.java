package local.jcore;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class SynchronizedTest {

    static class C {

        @SneakyThrows
        synchronized public void wt() {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }

    @Test
    public void test() throws InterruptedException {
        new Thread(() -> {
            new C().wt();
        }).start();
        new Thread(() -> {
            new C().wt();
        }).start();
        Thread.sleep(2000);
    }
}
