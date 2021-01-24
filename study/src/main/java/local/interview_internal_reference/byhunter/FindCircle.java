package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;

public class FindCircle {

    public ListNode findCircle(ListNode list) {
        if (list == null || list.next == null || list.next.next == null) {
            return null;
        }
        ListNode step1 = list.next, step2 = list.next.next;
        while (step1 != step2) {
            step1 = step1.next;
            step2 = step2.next;
            if (step2 == null) {
                return null;
            }
            step2 = step2.next;
            if (step1 == null || step2 == null) {
                return null;
            }
        }
        ListNode newStart = list;
        while (newStart != step1) {
            step1 = step1.next;
            newStart = newStart.next;
        }
        return newStart;
    }
}
