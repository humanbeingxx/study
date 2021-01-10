package local.algorithm.leetcode;

import local.algorithm.leetcode.common.ListNode;

public class SwapNodesOfLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head, second = head, node = head;
        int count = 0;
        for (int i = 1; i < k; i++) {
            first = first.next;
            node = node.next;
            count++;
        }
        while (node != null) {
            node = node.next;
            count++;
        }
        for (int i = 1; i <= count - k; i++) {
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}
