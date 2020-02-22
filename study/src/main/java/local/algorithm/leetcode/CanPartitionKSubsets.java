package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-22
 **/
public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        if (sum % k != 0 || sum / k < max) {
            return false;
        }
        boolean[] checked = new boolean[nums.length];
        return partitionRec(nums, k, sum / k, 0, 0, checked);
    }

    private boolean partitionRec(int[] nums, int k, int target, int curSum, int index, boolean[] checked) {
        if (k == 0) {
            return true;
        }
        if (curSum > target) {
            return false;
        }
        if (curSum == target) {
            return partitionRec(nums, k - 1, target, 0, 0, checked);
        }
        for (int i = index; i < nums.length; i++) {
            if (!checked[i] && curSum + nums[i] <= target) {
                checked[i] = true;
                if (partitionRec(nums, k, target, curSum + nums[i], i + 1, checked)) {
                    return true;
                }
                checked[i] = false;
            }
        }
        return false;
    }
}
