package local.algorithm.nowcoder.yuanfudao;

import com.google.common.base.Preconditions;
import local.algorithm.leetcode.common.ListNode;

public class ReverseListPart {

    public ListNode reverse(ListNode head, int start, int end) {
        Preconditions.checkArgument(end > start);
        ListNode dummy = new ListNode(0), pre = dummy;
        pre.next = head;
        for (int i = 0; i < start && pre != null; i++) {
            pre = pre.next;
        }
        if (pre == null || pre.next == null) {
            return head;
        }
        ListNode node = pre.next, first = null;
        pre.next = null;
        while (node != null && (end - start) >= 0) {
            ListNode next = node.next;
            if (first == null) {
                first = node;
            }
            node.next = pre.next;
            pre.next = node;
            node = next;
            end--;
        }
        first.next = node;
        return dummy.next;
    }
}
