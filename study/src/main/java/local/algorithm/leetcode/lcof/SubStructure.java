package local.algorithm.leetcode.lcof;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/13 16:33
 */
public class SubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return rec(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean rec(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return rec(A.left, B.left) && rec(A.right, B.right);
    }
}
