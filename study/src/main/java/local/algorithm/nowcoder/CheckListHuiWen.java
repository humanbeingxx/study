package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.ListNode;

public class CheckListHuiWen {

    ListNode node = null;

    public boolean check(ListNode head) {
        this.node = head;
        return checkRec(head);
    }

    private boolean checkRec(ListNode node) {
        boolean check = true;
        if (node.next != null) {
            check = checkRec(node.next);
        }
        if (!check || node.val != this.node.val) {
            return false;
        }
        this.node = this.node.next;
        return true;
    }
}
