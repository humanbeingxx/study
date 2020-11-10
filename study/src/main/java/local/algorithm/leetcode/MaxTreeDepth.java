package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class MaxTreeDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
