package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-20
 **/
public class SwapListPairsTest {

    @Test
    public void testSwapPairs1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode result = new SwapListPairs().swapPairs(head);
        System.out.println(result.show());
    }

    @Test
    public void testSwapPairs2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new SwapListPairs().swapPairs(head);
        System.out.println(result.show());
    }

    @Test
    public void testSwapPairs3() {
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode result = new SwapListPairs().swapPairs(head);
        System.out.println(result.show());
    }
}