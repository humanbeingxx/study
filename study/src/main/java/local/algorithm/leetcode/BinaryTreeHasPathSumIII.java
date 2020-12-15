package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class BinaryTreeHasPathSumIII {

    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        oneRoot(root, sum);
        return count;
    }

    private void oneRoot(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum - root.val == 0) {
            count++;
        }
        oneRoot(root.left, sum - root.val);
        oneRoot(root.right, sum - root.val);
    }
}
