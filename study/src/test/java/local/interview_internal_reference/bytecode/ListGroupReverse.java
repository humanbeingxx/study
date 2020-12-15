package local.interview_internal_reference.bytecode;

import local.algorithm.ListNode;

public class ListGroupReverse {

    /**
     * 将连表按k个一组翻转。简单起见，长度是k的倍数
     */
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("invalid k");
        }
        ListNode node = head, newHead = null, preTail = null;
        while (node != null) {
            ListNode tempHead = ListNode.EMPTY;
            ListNode currTail = null;
            for (int i = 0; i < k; i++) {
                if (currTail == null) {
                    currTail = node;
                }
                ListNode next = node.next;
                node.next = tempHead.next;
                tempHead.next = node;
                node = next;
            }
            currTail.next = null;
            if (newHead == null) {
                newHead = tempHead.next;
            }
            if (preTail != null) {
                preTail.next = tempHead.next;
            }
            preTail = currTail;
        }

        return newHead;
    }
}
