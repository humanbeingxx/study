package local.algorithm.leetcode;

import static local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class ListMiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode step1 = head;
        ListNode step2 = head.next;

        while (step2 != null) {
            step1 = step1.next;
            if (step2.next == null) {
                step2 = null;
            } else {
                step2 = step2.next.next;
            }
        }

        return step1;
    }
}
