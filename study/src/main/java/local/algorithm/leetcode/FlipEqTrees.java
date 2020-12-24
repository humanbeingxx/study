package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class FlipEqTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        }
        if (root1.left == null && root1.right == null) {
            return root2.left == null && root2.right == null;
        } else if (root1.left == null) {
            if (root2.left == null) {
                return flipEquiv(root1.right, root2.right);
            } else if (root2.right == null) {
                return flipEquiv(root1.right, root2.left);
            } else {
                return false;
            }
        } else if (root1.right == null) {
            if (root2.left == null) {
                return flipEquiv(root1.left, root2.right);
            } else if (root2.right == null) {
                return flipEquiv(root1.left, root2.left);
            } else {
                return false;
            }
        } else {
            if (root1.left.val == root1.right.val) {
                return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                        (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
            } else if (root2.left != null && root1.left.val == root2.left.val) {
                return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            } else if (root2.right != null && root1.left.val == root2.right.val) {
                return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            } else {
                return false;
            }
        }
    }

}
