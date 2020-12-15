package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class PruneZeroTree {

    public TreeNode pruneTree(TreeNode root) {
        boolean rootValid = rec(root);
        return rootValid ? root : null;
    }

    public boolean rec(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean left = rec(node.left);
        boolean right = rec(node.right);
        if (!left) {
            node.left = null;
        }
        if (!right) {
            node.right = null;
        }
        return left || right || node.val == 1;
    }
}
