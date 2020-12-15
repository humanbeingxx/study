package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class ValidBST {

    Integer curr;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (curr != null && root.val <= curr) {
            return false;
        }
        curr = root.val;
        return isValidBST(root.right);
    }
}
