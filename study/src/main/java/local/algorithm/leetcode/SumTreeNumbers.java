package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-13
 **/
public class SumTreeNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return rec(root, root.val);
    }

    private int rec(TreeNode node, int curr) {
        if (isLeaf(node)) {
            return curr;
        }
        int sum = 0;
        if (node.left != null) {
            sum += rec(node.left, curr * 10 + node.left.val);
        }
        if (node.right != null) {
            sum += rec(node.right, curr * 10 + node.right.val);
        }
        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
