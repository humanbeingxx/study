package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class RotateListRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode newHead,last = node;
        last.next = head;
        last = head;
        for (int i = 0; i < len - k - 1; i++) {
            last = last.next;
        }
        newHead = last.next;
        last.next = null;
        return newHead;
    }
}
