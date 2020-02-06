package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class MyCircularQueueTest {

    @Test
    public void test() {
        MyCircularQueue queue = new MyCircularQueue(2);
        queue.enQueue(1);
        queue.enQueue(2);
        assertTrue(queue.isFull());
        queue.deQueue();
        queue.deQueue();
        assertTrue(queue.isEmpty());

        queue.enQueue(1);
        queue.enQueue(2);
        assertEquals(queue.Front(), 1);
        assertEquals(queue.Rear(), 2);
    }

}