package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class UnivalTree {

    Integer val = null;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return rec(root);
    }

    private boolean rec(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (val == null) {
            val = node.val;
        }
        return node.val == val && rec(node.left) && rec(node.right);
    }
}
