package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class MaxProductTree {

    private long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        long rootSum = sumOfTree(root);
        findBest(root, rootSum);
        return (int)(maxProduct % 1000000007);
    }

    private long sumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumOfTree(root.left) + sumOfTree(root.right);
    }

    private long findBest(TreeNode root, long rootSum) {
        long sumLeft = 0, sumRight = 0;
        if (root.left != null) {
            sumLeft = findBest(root.left, rootSum);
            maxProduct = Math.max(sumLeft * (rootSum - sumLeft), maxProduct);
        }
        if (root.right != null) {
            sumRight += findBest(root.right, rootSum);
            maxProduct = Math.max(sumRight * (rootSum - sumRight), maxProduct);
        }
        return root.val + sumLeft + sumRight;
    }
}
