package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class BstToGst {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
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
        node.val += sum;
        sum = node.val;
        rec(node.left);
    }
}
