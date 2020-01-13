package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode(0), oddNode = oddHead;
        ListNode evenHead = new ListNode(0), evenNode = evenHead;
        boolean even = true;
        ListNode node = head, pre;
        while (node != null) {
            if (even) {
                evenNode.next = node;
                evenNode = evenNode.next;
                even = false;
            } else {
                oddNode.next = node;
                oddNode = oddNode.next;
                even = true;
            }
            pre = node;
            node = node.next;
            pre.next = null;
        }
        evenNode.next = oddHead.next;
        return evenHead.next;
    }
}
