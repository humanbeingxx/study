package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class ValidBST2 {

    Integer curr;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (curr != null && root.val <= curr) {
            return false;
        }
        curr = root.val;
        return isValidBST(root.right);
    }
}
