package local.jcore;

import org.junit.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-15
 **/
public class MyLinkedBlockingQueueTest {

    @Test
    public void test() throws InterruptedException {
        MyLinkedBlockingQueue<Integer> queue = new MyLinkedBlockingQueue<>(2);
        queue.offer(1);
        queue.offer(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.poll();
            }
        }).start();
        Thread.sleep(100);
        queue.offer(3);

        Thread.sleep(1200);
    }

}