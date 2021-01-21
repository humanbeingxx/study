package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;

public class MergeLinkedList {

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode node1 = list1, node2 = list2, head = new ListNode(0), node = head;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        while (node1 != null) {
            node.next = node1;
            node = node.next;
            node1 = node1.next;
        }
        while (node2 != null) {
            node.next = node2;
            node = node.next;
            node2 = node2.next;
        }
        return head.next;
    }
}
