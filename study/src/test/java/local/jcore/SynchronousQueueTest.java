package local.jcore;


import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cuixiaoshuang
 * @date 2020-01-16
 **/
public class SynchronousQueueTest {

    @Test
    public void test() throws InterruptedException {
        SynchronousQueue<Object> torch = new SynchronousQueue<>();
        List<Integer> result = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        torch.offer(new Object(), 10, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (result) {
                        result.add(2);
                    }
                    try {
                        torch.poll(10, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (result) {
                        result.add(1);
                    }
                    try {
                        torch.poll(10, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        torch.offer(new Object(), 10, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        Thread.sleep(400);
        System.out.println(result);
    }

    @Test
    public void viewCode() throws InterruptedException {
        SynchronousQueue<Object> queue = new SynchronousQueue<>(true);
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                queue.put(new Object());
            }
        }).start();

        Thread.sleep(100);

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                queue.put(new Object());
            }
        }).start();

        Thread.sleep(100);

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                queue.put(new Object());
            }
        }).start();

        Thread.sleep(100);
        queue.take();
    }

    @Test
    public void testOffer() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.DAYS, new SynchronousQueue<>());
        executor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(100000);
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        });
        Thread.sleep(1000);
    }
}
