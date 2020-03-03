package local.algorithm.leetcode;

public class ConnectTreeNextII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node currLevel = root, preNode = null, nextLevel = null;
        while (currLevel != null) {
            if (nextLevel == null) {
                if (currLevel.left != null) {
                    nextLevel = currLevel.left;
                } else if (currLevel.right != null) {
                    nextLevel = currLevel.right;
                }
            }
            if (currLevel.left != null) {
                if (preNode != null) {
                    preNode.next = currLevel.left;
                }
                preNode = currLevel.left;
            }
            if (currLevel.right != null) {
                if (preNode != null) {
                    preNode.next  = currLevel.right;
                }
                preNode = currLevel.right;
            }

            currLevel = currLevel.next;
            if (currLevel == null) {
                currLevel = nextLevel;
                nextLevel = null;
                preNode = null;
            }
        }
        return root;
    }
}
