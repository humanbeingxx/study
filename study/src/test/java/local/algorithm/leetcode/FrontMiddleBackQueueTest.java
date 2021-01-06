package local.algorithm.leetcode;

import org.testng.annotations.Test;

public class FrontMiddleBackQueueTest {

    @Test
    public void test1() {
        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        queue.pushFront(888438);
        queue.pushMiddle(772690);
        queue.pushMiddle(375192);
        queue.pushFront(411268);
        queue.pushFront(885613);
        queue.pushMiddle(508187);
        System.out.println(queue.popMiddle());
        System.out.println(queue.popMiddle());
        queue.pushMiddle(111498);
        queue.pushMiddle(296008);
        System.out.println(queue.popFront());
    }
}