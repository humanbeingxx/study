package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

public class ReverseList2Test {

    @Test
    public void testReverseList2() {
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode result = new ReverseList2().reverseList(head);
        System.out.println(result.show());
    }

    @Test
    public void testReverseList3() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = new ReverseList2().reverseList(head);
        System.out.println(result.show());
    }
}