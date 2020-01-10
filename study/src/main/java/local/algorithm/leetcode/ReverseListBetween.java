package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class ReverseListBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) {
            return head;
        }

        ListNode node = head, pre = null;
        int index = 0;
        for (; index < m - 1; index++) {
            if (node == null) {
                return head;
            }
            pre = node;
            node = node.next;
        }
        if (pre == null) {
            return reverseK(node, n - m);
        } else {
            pre.next = reverseK(node, n - m);
        }

        return head;
    }

    ListNode reverseK(ListNode head, int k) {
        ListNode pre = head;
        ListNode curr = pre.next;
        pre.next = null;
        while (curr != null && k > 0) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            k--;
        }
        head.next = curr;
        return pre;
    }
}
