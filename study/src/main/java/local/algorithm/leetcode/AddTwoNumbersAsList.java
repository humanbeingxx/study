package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class AddTwoNumbersAsList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int left, ahead = 0;
        ListNode head = null, pre = null, next = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + ahead;
            left = sum % 10;
            ahead = sum / 10;
            if (pre == null) {
                pre = new ListNode(left);
                head = pre;
            } else {
                next = new ListNode(left);
                pre.next = next;
                pre = pre.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + ahead;
            left = sum % 10;
            ahead = sum / 10;
            if (pre == null) {
                pre = new ListNode(left);
                head = pre;
            } else {
                next = new ListNode(left);
                pre.next = next;
                pre = pre.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + ahead;
            left = sum % 10;
            ahead = sum / 10;
            if (pre == null) {
                pre = new ListNode(left);
                head = pre;
            } else {
                next = new ListNode(left);
                pre.next = next;
                pre = pre.next;
            }
            l2 = l2.next;
        }
        if (ahead != 0) {
            pre.next = new ListNode(1);
        }
        return head;
    }
}
