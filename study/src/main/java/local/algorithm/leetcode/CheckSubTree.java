package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class CheckSubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        } else if (s == null) {
            return false;
        }
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
