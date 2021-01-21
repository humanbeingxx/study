package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;

public class ReverseLinkedList {

    public ListNode reverse(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode fake = new ListNode(0), node = list, next;
        while (node != null) {
            next = node.next;
            node.next = fake.next;
            fake.next = node;
            node = next;
        }
        return fake.next;
    }
}
