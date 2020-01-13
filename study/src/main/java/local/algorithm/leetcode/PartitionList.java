package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, node = head;
        ListNode smallHead = new ListNode(0, null), smallNode = smallHead;
        ListNode bigHead = new ListNode(0, null), bigNode = bigHead;
        while (node != null) {
            if (node.val < x) {
                smallNode.next = node;
                smallNode = smallNode.next;
            } else {
                bigNode.next = node;
                bigNode = bigNode.next;
            }
            pre = node;
            node = node.next;
            pre.next = null;
        }

        smallNode.next = bigHead.next;
        return smallHead.next;
    }
}
