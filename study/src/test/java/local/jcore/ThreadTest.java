package local.jcore;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

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

    static class MyR implements Runnable {
        int id;

        public MyR(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            if (id == 3) {
                throw new RuntimeException();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SneakyThrows
    @Test
    public void testException() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.execute(new MyR(i));
        }
        Thread.sleep(1500);
    }

    @SneakyThrows
    @Test
    public void testExceptionFuture() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> results = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            results.add(pool.submit(() -> {
                if (index == 3) {
                    throw new RuntimeException();
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return index;
                }
            }));
        }
        for (Future<Integer> result : results) {
            System.out.println(result.get());
        }
    }
}
