package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class MinTreeDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rec(root, 0);
    }

    private int rec(TreeNode node, int length) {
        if (node.left == null && node.right == null) {
            return length + 1;
        }
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
        if (node.left != null) {
            leftMin = rec(node.left, length + 1);
        }
        if (node.right != null) {
            rightMin = rec(node.right, length + 1);
        }
        return Math.min(leftMin, rightMin);
    }
}
