package local.algorithm.leetcode;

import static local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        rec(root);
        return max;
    }

    private int rec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int right = rec(node.right);
        int left = rec(node.left);
        if (left + right > max) {
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
