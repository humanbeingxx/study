package local.algorithm.nowcoder;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupInList {

    static class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void removeDup(ListNode head) {
        Set<Integer> existValues = new HashSet<>();
        ListNode node = head, next;
        while (node != null) {
            next = node.next;
            if (existValues.contains(node.val)) {
                del(node);
            } else {
                existValues.add(node.val);
            }
            node = next;
        }
    }

    private void del(ListNode node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
    }
}
