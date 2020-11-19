package local.algorithm.leetcode;

public class FlattenLevelNode {

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    };

    public Node flatten(Node head) {
        rec(head);
        return head;
    }

    private Node rec(Node node) {
        if (node == null) {
            return null;
        }
        Node pre = null, next = null;
        while (node != null) {
            pre = node;
            next = node.next;
            if (node.child != null) {
                Node nextLevelLast = rec(node.child);
                node.child.prev = node;
                node.next = node.child;
                nextLevelLast.next = next;
                next.prev = nextLevelLast;
            }
            node = next;
        }
        return pre;
    }

    public String show(Node head) {
        Node node = head, pre = null;
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.val).append("->");
            pre = node;
            node = node.next;
        }
        stringBuilder.append("\n");
        while (pre != null) {
            stringBuilder.append("<-").append(pre.val);
            pre = pre.prev;
        }

        return stringBuilder.toString();
    }
}
