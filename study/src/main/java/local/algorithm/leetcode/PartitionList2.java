package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class PartitionList2 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode bigList = new ListNode(0), smallList = new ListNode(0);
        ListNode node = head, pre, bigNode = bigList, smallNode = smallList;
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
        smallNode.next = bigList.next;
        return smallList.next;
    }
}
