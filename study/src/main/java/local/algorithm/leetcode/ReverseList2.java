package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

public class ReverseList2 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0);
        ListNode node = head.next;
        fake.next = head;
        head.next = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = fake.next;
            fake.next = node;
            node = next;
        }
        return fake.next;
    }
}
