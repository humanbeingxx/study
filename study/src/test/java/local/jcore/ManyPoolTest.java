package local.jcore;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ManyPoolTest {

    @Test
    public void test() {
        List<ExecutorService> executorServices = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executorServices.add(executor);
            executor.submit(() -> {

            });
            if (i % 10000 == 0) {
                System.out.println(Thread.getAllStackTraces().keySet().size());
                System.out.println(executorServices.get(0));
            }
        }
    }

    @Test
    public void test2() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            Thread thread = new Thread();
            threads.add(thread);
            thread.start();
            if (i % 10000 == 0) {
                System.out.println(Thread.getAllStackTraces().keySet().size());
                System.out.println(threads.get(0).isAlive());
            }
        }
    }

    @Test
    public void testThreadSize() throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 2000000; i++) {
            threadList.add(new Thread());
        }
        System.out.println("finished");
        Thread.sleep(10000000);
    }

    @Test
    public void testKeepAlive() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10));
        for (int i = 0; i < 20; i++) {
            executor.submit(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                }
            });
        }
        Thread.sleep(1500);
        System.out.println(executor);
    }

    @Test
    public void testThreadGroup() throws InterruptedException {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        Thread thread = new Thread(threadGroup, () -> {

        });
        thread.start();
        Thread.sleep(300);
        System.out.println(thread.isAlive());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread.sleep(300);

        System.out.println(executor);
    }
}
