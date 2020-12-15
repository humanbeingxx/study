package local.jcore;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class WatchThreadTest {

    class WatchTask implements Runnable {
        Thread thread;

        public WatchTask(Thread thread) {
            this.thread = thread;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (thread.isAlive()) {
                System.out.println("living");
                Thread.sleep(500);
            }
            System.out.println("stop watch");
        }
    }

    @Test
    public void test() throws InterruptedException {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                new Thread(new WatchTask(thread)).start();
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(300);
                }
                throw new Exception();
            }
        }).start();
        Thread.sleep(10000);

    }
}
