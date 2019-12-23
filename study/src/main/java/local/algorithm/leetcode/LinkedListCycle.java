package local.algorithm.leetcode;

import static local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode step1 = head.next;
        ListNode step2 = head.next.next;
        while (step1 != null && step2 != null) {
            if (step1 == step2) {
                return true;
            }
            step1 = step1.next;
            step2 = step2.next;
            if (step2 == null) {
                return false;
            } else {
                step2 = step2.next;
            }
        }
        return false;
    }
}
