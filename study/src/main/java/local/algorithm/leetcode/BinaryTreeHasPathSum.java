package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 20:55
 */
public class BinaryTreeHasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return rec(root, sum);
    }

    private boolean rec(TreeNode node, int sum) {
        int sub = sum - node.val;
        if (sub == 0 && node.left == null && node.right == null) {
            return true;
        }
        boolean checkLeft, checkRight;
        if (node.left != null) {
            checkLeft = rec(node.left, sub);
            if (checkLeft) {
                return true;
            }
        }
        if (node.right != null) {
            checkRight = rec(node.right, sub);
            return checkRight;
        }

        return false;
    }
}
