package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class SymmetricTree2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        } else {
            return rec(root.left, root.right);
        }
    }

    private boolean rec(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        } else if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return rec(left.left, right.right) && rec(left.right, right.left);
    }
}
