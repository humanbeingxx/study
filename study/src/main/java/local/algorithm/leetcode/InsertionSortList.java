package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-21
 **/
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0), node = head.next;
        fake.next = head;
        head.next = null;
        while (node != null) {
            ListNode sorted = fake;
            while (true) {
                if (sorted.next == null) {
                    sorted.next = node;
                    ListNode next = node.next;
                    node.next = null;
                    node = next;
                    break;
                } else if (sorted.next.val > node.val) {
                    ListNode next = node.next;
                    node.next = sorted.next;
                    sorted.next = node;
                    node = next;
                    break;
                } else {
                    sorted = sorted.next;
                }
            }
        }
        return fake.next;
    }
}
