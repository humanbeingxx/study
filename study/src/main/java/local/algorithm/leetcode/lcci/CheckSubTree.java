package local.algorithm.leetcode.lcci;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/19 16:54
 */
public class CheckSubTree {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 != null && t1 == null) {
            return false;
        } else if (t2 == null) {
            return true;
        }
        if (t1.val == t2.val) {
            return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        } else {
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        }
    }
}
