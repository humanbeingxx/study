package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 20:10
 */
public class SumRootToLeaf {

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        rec(root, 0);
        return sum % ((int) Math.pow(10, 9) + 7);
    }

    private void rec(TreeNode node, int preSum) {
        if (node == null) {
            return;
        }
        int currSum = (preSum << 1) + node.val;
        if (node.left == null && node.right == null) {
            sum += currSum;
            return;
        }
        if (node.left != null) {
            rec(node.left, currSum);
        }
        if (node.right != null) {
            rec(node.right, currSum);
        }
    }
}
