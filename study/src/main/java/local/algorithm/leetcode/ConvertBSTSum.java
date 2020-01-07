package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class ConvertBSTSum {

    private int currSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        rec(root);
        return root;
    }

    private void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        rec(node.right);
        int preVal = node.val;
        node.val += currSum;
        currSum += preVal;
        rec(node.left);
    }
}
