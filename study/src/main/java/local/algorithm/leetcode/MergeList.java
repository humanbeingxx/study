package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/25 22:06
 */
public class MergeList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0, null);
        ListNode head = root;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else if (l2 == null) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    head.next = l2;
                    l2 = l2.next;
                    head = head.next;
                } else if (l1.val < l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                    head = head.next;
                } else {
                    head.next = l1;
                    l1 = l1.next;
                    head = head.next;
                    head.next = l2;
                    l2 = l2.next;
                    head = head.next;
                }
            }
        }
        return root.next;
    }
}
