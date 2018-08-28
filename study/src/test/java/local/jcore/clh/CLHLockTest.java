package local.jcore.clh;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**

 *
 * @author xiaoshuang.cui
 * @date 2018/8/27 下午3:32
 **/
public class CLHLockTest {

    private static CLHLock lock = new CLHLock();

    @Test
    public void test() throws InterruptedException {
        new Thread(() -> {
            lock.lock();
            lock.unlock();
        }).start();

        Thread.sleep(100);
    }

    @Test
    public void testWithSleep() throws InterruptedException {
        withSleep(200);
    }

    /**
     * 没有睡眠中断的
     * @throws InterruptedException
     */
    @Test
    public void testWithoutSleep() throws InterruptedException {
        List<Integer> list = Lists.newArrayList();
        List<Thread> threads = Lists.newArrayList();

        for (int i = 0; i < 200; i++) {
            threads.add(new Thread(() -> {
                try {
                    Thread.sleep(10);
                    lock.lock();
                    System.out.println("get lock " + Thread.currentThread().getName());
                    list.add(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }));
        };

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(500);
        lock.lock();
        Assert.assertEquals(list.size(), 200);
        lock.unlock();
    }

    @Test
    public void testWithSleepSmall() throws InterruptedException {
        withSleep(10);
    }

    private void withSleep(int size) throws InterruptedException {
        List<Integer> list = Lists.newArrayList();
        List<Thread> threads = Lists.newArrayList();

        for (int i = 0; i < size; i++) {
            threads.add(new Thread(() -> {
                try {
                    Thread.sleep(10);
                    lock.lockWithSleep();
                    System.out.println("get lock " + Thread.currentThread().getName());
                    list.add(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }));
        };

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(500);
        lock.lockWithSleep();
        Assert.assertEquals(list.size(), size);
        lock.unlock();
    }
}