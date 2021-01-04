package local.algorithm.leetcode;

import local.algorithm.leetcode.common.ListNode;

public class PartitionList20210103 {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode node = head, smallNode = smallHead, bigNode = bigHead;
        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                smallNode.next = node;
                smallNode = node;
            } else {
                bigNode.next = node;
                bigNode = node;
            }
            node.next = null;
            node = next;
        }

        smallNode.next = bigHead.next;
        return smallHead.next;
    }
}
