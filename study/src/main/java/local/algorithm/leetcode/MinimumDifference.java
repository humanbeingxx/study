package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class MinimumDifference {

    int min = Integer.MAX_VALUE;

    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        rec(root);
        return min;
    }

    private void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        rec(node.left);
        if (pre != null) {
            min = Math.min(Math.abs(pre.val - node.val),min);
        }
        pre = node;
        rec(node.right);
    }
}
