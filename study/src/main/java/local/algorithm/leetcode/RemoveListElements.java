package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 22:19
 */
public class RemoveListElements {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        ListNode(int x) {
            val = x;
        }

        public String show() {
            ListNode node = this;
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                node = node.next;
            } else {
                pre = node;
                node = node.next;
            }
        }

        return head;
    }
}
