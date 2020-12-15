package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        return rec(root.left, root.right);
    }

    private boolean rec(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        if (left.left != null) {
            if (right.right == null) {
                return false;
            }
            if (!rec(left.left, right.right)) {
                return false;
            }
        } else if (right.right != null) {
            return false;
        }
        if (left.right != null) {
            if (right.left == null) {
                return false;
            }
            if (!rec(left.right, right.left)) {
                return false;
            }
        } else if (right.left != null) {
            return false;
        }
        return true;
    }
}
