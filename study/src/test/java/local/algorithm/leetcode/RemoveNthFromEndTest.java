package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-21
 **/
public class RemoveNthFromEndTest {

    @Test
    public void testRemoveNthFromEnd1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new RemoveNthFromEnd().removeNthFromEnd(head, 1);
        System.out.println(result.show());
    }

    @Test
    public void testRemoveNthFromEnd2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new RemoveNthFromEnd().removeNthFromEnd(head, 2);
        System.out.println(result.show());
    }

    @Test
    public void testRemoveNthFromEnd5() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new RemoveNthFromEnd().removeNthFromEnd(head, 5);
        System.out.println(result.show());
    }

    @Test
    public void testRemoveNthFromEnd1_2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new RemoveNthFromEnd().removeNthFromEnd2(head, 1);
        System.out.println(result.show());
    }

    @Test
    public void testRemoveNthFromEnd2_2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new RemoveNthFromEnd().removeNthFromEnd2(head, 2);
        System.out.println(result.show());
    }

    @Test
    public void testRemoveNthFromEnd5_2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new RemoveNthFromEnd().removeNthFromEnd2(head, 5);
        System.out.println(result.show());
    }
}