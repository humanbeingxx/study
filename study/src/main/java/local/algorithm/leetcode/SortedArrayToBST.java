package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return rec(nums, 0, nums.length - 1);
    }

    private TreeNode rec(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int pos = (low + high) / 2;
        TreeNode node = new TreeNode(nums[pos], null, null);
        node.left = rec(nums, low, pos - 1);
        node.right = rec(nums, pos + 1, high);
        return node;
    }
}
