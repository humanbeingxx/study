package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class LongestUnivaluePath2 {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return rec(root);
    }

    private int rec(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int currentLen = findInSubPath(root.left, root.val) + findInSubPath(root.right, root.val);
        int leftLen = rec(root.left);
        int rightLen = rec(root.right);
        return Math.max(currentLen, Math.max(leftLen, rightLen));
    }

    private int findInSubPath(TreeNode node, int val) {
        if (node == null || node.val != val) {
            return 0;
        }
        int leftPath = findInSubPath(node.left, val);
        int rightPath = findInSubPath(node.right, val);
        return 1 + Math.max(leftPath, rightPath);
    }
}
