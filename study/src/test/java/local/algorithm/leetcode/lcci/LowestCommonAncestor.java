package local.algorithm.leetcode.lcci;

import local.algorithm.leetcode.common.TreeNode;

public class LowestCommonAncestor {

    private boolean foundP = false;
    private boolean foundQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            foundP = true;
            if (search(p, q)) {
                return p;
            } else {
                return null;
            }
        } else if (root == q) {
            foundQ = true;
            if (search(q, p)) {
                return q;
            } else {
                return null;
            }
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left != null) {
            return left;
        }
        if (foundP) {
            if (search(root.right, q)) {
                return root;
            } else {
                return null;
            }
        }
        if (foundQ) {
            if (search(root.right, p)) {
                return root;
            } else {
                return null;
            }
        }
        return lowestCommonAncestor(root.right, p, q);
    }

    private boolean search(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            return true;
        }
        return search(root.left, target) || search(root.right, target);
    }
}
