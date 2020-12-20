package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        int[] result = new int[1];
        rec(root, Integer.MIN_VALUE, result);
        return result[0];
    }

    private void rec(TreeNode root, int maxInPath, int[] result) {
        if (root == null) {
            return;
        }
        if (root.val >= maxInPath) {
            result[0]++;
            maxInPath = root.val;
        }
        rec(root.left, maxInPath, result);
        rec(root.right, maxInPath, result);
    }
}
