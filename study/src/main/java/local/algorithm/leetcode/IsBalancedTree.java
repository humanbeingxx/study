package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

public class IsBalancedTree {

    public boolean isBalanced(TreeNode root) {
        return calcDepth(root, 0) != -1;
    }

    private int calcDepth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        int leftDepth = calcDepth(node.left, level + 1);
        int rightDepth = calcDepth(node.right, level + 1);
        if (leftDepth == - 1 || rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
