package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class DeleteDuplicatesInSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0), newNode = newHead;
        int curVal = head.val;
        ListNode pre = head, curr = head.next;
        while (curr != null) {
            if (curr.val == curVal) {
                pre = null;
            } else {
                if (pre != null) {
                    newNode.next = pre;
                    newNode = pre;
                }
                curVal = curr.val;
                pre = curr;
            }
            curr = curr.next;
        }
        if (pre != null) {
            newNode.next = pre;
            newNode = newNode.next;
        }
        newNode.next = null;
        return newHead.next;
    }
}
