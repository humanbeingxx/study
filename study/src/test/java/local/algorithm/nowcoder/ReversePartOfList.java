package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.ListNode;

public class ReversePartOfList {

    public ListNode reverse(ListNode head, ListNode start, ListNode end) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy;
        while (before.next != start) {
            before = before.next;
        }
        before.next = end.next;
        ListNode node = start, next = null;
        while (next != end) {
            next = node.next;
            node.next = before.next;
            before.next = node;
            node = next;
        }
        return dummy.next;
    }
}
