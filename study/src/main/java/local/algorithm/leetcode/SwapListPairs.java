package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-20
 **/
public class SwapListPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, first = head, second = first.next, next = second.next;
        head = second;
        while (true) {
            pre.next = second;
            second.next = first;
            first.next = next;

            pre = first;
            first = first.next;
            if (first == null || first.next == null) {
                break;
            }
            second = first.next;
            next = second.next;
        }

        return head;
    }
}
