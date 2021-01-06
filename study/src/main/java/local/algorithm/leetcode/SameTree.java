package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return rec(p, q);
    }

    private boolean rec(TreeNode p, TreeNode q) {
        if (p.val != q.val) {
            return false;
        }
        if (p.left == null && p.right == null && q.left == null && q.right == null) {
            return true;
        }
        boolean left = false, right = false;
        if (p.left == null && q.left == null) {
            left = true;
        } else if (p.left != null && q.left != null) {
            left = rec(p.left, q.left);
        }
        if (p.right == null && q.right == null) {
            right = true;
        } else if (p.right != null && q.right != null) {
            right = rec(p.right, q.right);
        }
        return left && right;
    }
}
