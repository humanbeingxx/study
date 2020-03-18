package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

public class MinDiffInBST {

    int min = Integer.MAX_VALUE;

    private TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        rec(root);
        return min;
    }

    private void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        rec(node.left);
        if (pre != null) {
            min = Math.min(node.val - pre.val,min);
        }
        pre = node;
        rec(node.right);
    }
}
