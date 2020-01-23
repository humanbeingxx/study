package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-21
 **/
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode node = head, pre = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (n == len) {
            return head.next;
        }
        node = head;
        while (len > n) {
            len--;
            pre = node;
            node = node.next;
        }
        pre.next = node.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode front = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        if (front == null) {
            return head.next;
        }
        front = front.next;
        ListNode node = head;
        while (front != null) {
            front = front.next;
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}
