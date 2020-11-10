package local.other;

import org.testng.annotations.Test;

public class ThreadLocalWeakRefTest {

    static ThreadLocal<String> val = new ThreadLocal<>();

    @Test
    public void test() throws InterruptedException {
        val.set(Thread.currentThread().getName());
        System.gc();
        val.set(null);
    }
}
