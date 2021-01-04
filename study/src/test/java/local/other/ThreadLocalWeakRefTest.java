package local.other;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalWeakRefTest {

    static ThreadLocal<String> val = new ThreadLocal<>();

    @Test
    public void test() throws InterruptedException {
        val.set(Thread.currentThread().getName());
        System.gc();
        val.set(null);
    }

    @Test
    public void testValue() throws Exception {
        val.set(Thread.currentThread().getName());
        System.gc();
        Field field = Thread.class.getDeclaredField("threadLocals");
        field.setAccessible(true);
        Object o = field.get(Thread.currentThread());
        System.out.println(o);
    }

    @Test
    public void testThreadExit() {
        new Thread().start();
    }

    static ThreadLocal<int[]> huge = new ThreadLocal<>();

    @Test
    public void testPool() throws Exception {
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(0, 10, 10000,
//                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024));
        ThreadPoolExecutor pool = new ThreadPoolExecutor(0, 10, 10000,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024));
        for (int i = 0; i < 10; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    huge.set(new int[20 * 1024 * 1024]);
                }
            });
        }
        Thread.sleep(10000);
        System.out.println("sleep 10s");
        System.gc();
        System.out.println("gc done");
        Thread.sleep(10000000);
    }
}
