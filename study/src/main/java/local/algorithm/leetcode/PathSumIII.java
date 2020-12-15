package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class PathSumIII {

    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sumOneRoot(root, 0, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void sumOneRoot(TreeNode root, int currSum, int target) {
        if (root == null) {
            return;
        }
        if (root.val + currSum == target) {
            count++;
        }
        sumOneRoot(root.left, currSum + root.val, target);
        sumOneRoot(root.right, currSum + root.val, target);
    }
}
