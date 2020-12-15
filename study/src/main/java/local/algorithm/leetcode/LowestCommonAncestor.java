package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int leftVal = Math.min(p.val, q.val);
        int rightVal = Math.max(p.val, q.val);
        return rec(root, leftVal, rightVal);
    }

    private TreeNode rec(TreeNode node, int leftVal, int rightVal) {
        if (node == null) {
            return null;
        }
        if (node.val == leftVal || node.val == rightVal) {
            return node;
        }
        if (node.val < leftVal) {
            return rec(node.right, leftVal, rightVal);
        }
        if (node.val > rightVal) {
            return rec(node.left, leftVal, rightVal);
        }
        return node;
    }
}
