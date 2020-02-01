package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-01
 **/
public class RemoveZeroSumSublists {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head.val == 0 ? null : head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;

        while (pre !=null) {
            int sum = 0;
            ListNode curr = pre.next;
            while (curr != null) {
                sum += curr.val;
                if (sum == 0) {
                    pre.next = curr.next;
                    curr = pre.next;
                } else {
                    curr = curr.next;
                }
            }
            pre = pre.next;
        }


        return fake.next;
    }
}
