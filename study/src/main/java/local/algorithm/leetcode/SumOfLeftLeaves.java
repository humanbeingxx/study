package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rec(root.left, true) + rec(root.right, false);
    }

    private int rec(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            if (isLeft) {
                return node.val;
            } else {
                return 0;
            }
        }
        return rec(node.left, true) + rec(node.right, false);
    }
}
