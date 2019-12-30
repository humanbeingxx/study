package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class PalindromeList {

    private int len;
    private ListNode half;

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len <= 1) {
            return true;
        }
        return rec(head, len / 2);

    }

    private boolean rec(ListNode node, int count) {
        if (count == 1) {
            if (len % 2 == 0) {
                half = node.next;

            } else {
                half = node.next.next;
            }
            return node.val == half.val;
        }
        boolean rec = rec(node.next, count - 1);
        if (!rec) {
            return false;
        }
        half = half.next;
        return node.val == half.val;
    }
}
