package local.algorithm.leetcode.lcof;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/13 13:59
 */
public class TreeToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node prev = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        rec(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void rec(Node node) {
        if (node == null) {
            return;
        }
        rec(node.left);
        if (prev != null) {
            node.left = prev;
            prev.right = node;
        } else {
            head = node;
        }
        prev = node;
        rec(node.right);
    }
}
