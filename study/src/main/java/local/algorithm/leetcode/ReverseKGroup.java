package local.algorithm.leetcode;

import local.algorithm.leetcode.common.ListNode;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        int count = count(head);
        if (k > count) {
            k %= count;
        }
        if (k == 1) {
            return head;
        }

        ListNode node = head, next, last = null, fake = new ListNode(0), result = null;
        while (node != null) {
            if (count < k) {
                for (int i = 0; i < count; i++) {
                    fake.next =node;
                    node = node.next;
                    fake = fake.next;
                }
                break;
            }
            last = node;
            for (int i = 0; i < k; i++, count--) {
                next = node.next;
                node.next = fake.next;
                fake.next = node;
                node = next;
            }
            if (result == null) {
                result = fake.next;
            }
            fake = last;
        }
        return result;
    }

    private int count(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
}
