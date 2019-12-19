package local.algorithm.leetcode;

import static local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class ListIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);

        if (lenA > lenB) {
            headA = moveAhead(headA, lenA - lenB);
        } else if (lenA < lenB) {
            headB = moveAhead(headB, lenB - lenA);
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int len(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private ListNode moveAhead(ListNode node, int step) {
        ListNode moved = node;
        for (int i = 0; i < step; i++) {
            moved = moved.next;
        }
        return moved;
    }
}
