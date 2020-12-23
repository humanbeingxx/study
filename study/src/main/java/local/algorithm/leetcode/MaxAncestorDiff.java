package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class MaxAncestorDiff {

    int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        rec(root.left, root.val, root.val);
        rec(root.right, root.val, root.val);
        return max;
    }

    private void rec(TreeNode node, int rootMin, int rootMax) {
        if (node == null) {
            return;
        }
        max = Math.max(Math.max(Math.abs(node.val - rootMin), Math.abs(node.val - rootMax)), max);
        int currMin = Math.min(node.val, rootMin);
        int currMax = Math.max(node.val, rootMax);
        rec(node.left, currMin, currMax);
        rec(node.right, currMin, currMax);
    }
}
