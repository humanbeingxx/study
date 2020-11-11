package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class ConvertBSTSum2 {

    TreeNode pre = null;

    public TreeNode convertBST(TreeNode root) {
        rec(root);
        return root;
    }

    private void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        rec(node.right);
        if (pre == null) {
            pre = node;
        } else {
            node.val += pre.val;
            pre = node;
        }
        rec(node.left);
    }
}
