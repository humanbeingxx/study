package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class FlattenTree {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left, node = left;
        if (left == null) {
            return;
        }
        while (node.right!= null) {
            node = node.right;
        }
        node.right = root.right;
        root.right = left;
        root.left = null;
    }
}
