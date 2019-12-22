package local.algorithm.leetcode;

import static local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 15:25
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = rec(head);
        head.next =null;
        return newHead;
    }

    private ListNode rec(ListNode node) {
        if (node.next == null) {
            return node;
        } else {
            ListNode head = rec(node.next);
            ListNode next = node.next;
            next.next = node;
            return head;
        }
    }
}
