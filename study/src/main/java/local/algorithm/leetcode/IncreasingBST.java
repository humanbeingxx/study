package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 21:34
 */
public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = root;
        while (newRoot.left != null) {
            newRoot = newRoot.left;
        }
        rec(root);
        return newRoot;
    }

    TreeNode rec(TreeNode node) {
        if (node == null) {
            return null;
        }

        node.right = rec(node.right);

        if (node.left != null) {
            TreeNode pre = node.left;
            TreeNode left = node.left;
            node.left = null;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = node;
            return rec(left);
        } else {
            return node;
        }
    }
}
