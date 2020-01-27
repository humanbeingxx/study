package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-24
 **/
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        count = count % 2 == 0 ? count / 2 : (count / 2 + 1);
        node = head;
        ListNode incHead = new ListNode(0), incNode = incHead;
        ListNode decHead = new ListNode(0);
        for (int i = 0; i < count; i++) {
            incNode.next = node;
            node = node.next;
            incNode = incNode.next;
        }
        incNode.next = null;

        ListNode next;
        while (node != null) {
            next = decHead.next;
            decHead.next = node;
            node = node.next;
            decHead.next.next = next;
        }

        incHead = incHead.next;
        decHead = decHead.next;
        node = new ListNode(0);
        while (incHead != null && decHead != null) {
            node.next = incHead;
            incHead = incHead.next;
            node = node.next;
            node.next = decHead;
            decHead = decHead.next;
            node = node.next;
        }
        if (incHead != null) {
            node.next = incHead;
            node.next.next = null;
        }
    }
}
