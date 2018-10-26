package local.jcore;

import org.testng.annotations.Test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/24 下午5:42
 **/
public class QueueTest {

    static ThreadLocal<String> local = new ThreadLocal<>();

    @Test
    public void testB() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(1);
//        queue.add("1");
//        queue.add("2");
//        queue.add("3");
        queue.remove();
    }

    @Test
    public void testNB() throws InterruptedException {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.add("1");
        queue.add("2");
        queue.add("3");

    }

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> local.set("test String")).start();
        }
        Thread.sleep(100000);
    }
}
