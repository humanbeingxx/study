package local.algorithm.leetcode;

public class MergeInBetweenLinkedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String print() {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                stringBuilder.append(node.val).append("->");
                node = node.next;
            }
            return stringBuilder.toString();
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1;
        int index = 0;
        while (index < a - 1) {
            node = node.next;
            index++;
        }
        ListNode start = node;
        while (index <= b) {
            node = node.next;
            index++;
        }
        ListNode end = node;
        start.next = list2;
        node = list2;
        while (node.next != null) {
            node = node.next;
        }
        node.next = end;
        return list1;
    }
}
