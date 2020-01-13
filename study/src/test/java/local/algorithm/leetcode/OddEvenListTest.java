package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class OddEvenListTest {

    @Test
    public void testOddEvenList1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new OddEvenList().oddEvenList(head);
        System.out.println(result.show());
    }

    @Test
    public void testOddEvenList2() {
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ListNode result = new OddEvenList().oddEvenList(head);
        System.out.println(result.show());
    }
}