package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;

public class RemoveDup {

    public ListNode removeDup(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode pre = list, node = list.next;
        while (node != null) {
            ListNode next = node.next;
            if (pre.val == node.val) {
                pre.next = next;
            } else {
                pre = node;
            }
            node = next;
        }
        return list;
    }
}
