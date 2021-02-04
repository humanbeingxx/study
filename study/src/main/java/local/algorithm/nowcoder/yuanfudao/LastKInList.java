package local.algorithm.nowcoder.yuanfudao;

import local.algorithm.leetcode.common.ListNode;

public class LastKInList {

    public ListNode lastK(ListNode head, int k) {
        if (k < 0 || head == null) {
            return null;
        }
        int count = count(head);
        if (k > count) {
            return null;
        }
        int index = count - k;
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node  = node.next;
        }
        return node;
    }

    private int count(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public ListNode lastKWithRec(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        return lastKRec(head, k, new int[1]);
    }

    private ListNode lastKRec(ListNode node, int k, int[] currentIndex) {
        if (node == null) {
            currentIndex[0] = 1;
            return null;
        }
        ListNode next = lastKRec(node.next, k, currentIndex);
        if (next != null) {
            return next;
        }
        if (currentIndex[0] == k) {
            return node;
        } else {
            currentIndex[0]++;
            return null;
        }
    }
}
