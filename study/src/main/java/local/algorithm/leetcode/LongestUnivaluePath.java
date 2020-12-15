package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 21:03
 */
public class LongestUnivaluePath {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        rec(root);
        return max;
    }

    private int rec(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int leftValue = rec(node.left);
        int rightValue = rec(node.right);

        if (node.left != null && node.val == node.left.val) {
            left = leftValue + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            right = rightValue + 1;
        }

        max = Math.max(max, left + right);

        return Math.max(left, right);
    }
}
