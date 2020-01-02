package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 21:48
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        rec(root);
        return root;
    }

    private void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        rec(node.left);
        rec(node.right);
    }

}
