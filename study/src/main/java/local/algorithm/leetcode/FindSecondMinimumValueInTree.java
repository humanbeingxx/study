package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class FindSecondMinimumValueInTree {

    private int bottom1 = -1;
    private int bottom2 = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        rec(root);
        return bottom2 < 0 ? -1 : bottom2;
    }

    private void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val < bottom1 || bottom1 < 0) {
            bottom2 = bottom1;
            bottom1 = node.val;
        } else if (node.val > bottom1 && (node.val < bottom2 || bottom2 < 0)) {
            bottom2 = node.val;
        }
        rec(node.left);
        rec(node.right);
    }
}
