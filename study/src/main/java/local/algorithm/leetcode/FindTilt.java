package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:09
 */
public class FindTilt {

    int tilt = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        rec(root);
        return tilt;
    }

    private int rec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = rec(root.left);
        int right = rec(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
