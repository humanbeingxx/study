package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;

public class LinkedListAddOne {

    public ListNode add(ListNode list) {
        boolean remain = addRec(list);
        if (remain) {
            ListNode head = new ListNode(1);
            head.next = list;
            return head;
        }
        return list;
    }

    private boolean addRec(ListNode node) {
        if (node.next != null && !addRec(node.next)) {
            return false;
        }
        if (node.val == 9) {
            node.val = 0;
            return true;
        } else {
            node.val += 1;
            return false;
        }
    }
}
