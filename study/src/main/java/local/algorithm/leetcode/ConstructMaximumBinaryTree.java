package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-23
 **/
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int low = 0, high = nums.length - 1;
        return build(nums, low, high);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return new TreeNode(nums[low]);
        }
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        TreeNode left = build(nums, low, maxIndex - 1);
        TreeNode right = build(nums, maxIndex + 1, high);
        root.left = left;
        root.right = right;
        return root;
    }
}
