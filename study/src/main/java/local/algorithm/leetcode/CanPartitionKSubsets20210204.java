package local.algorithm.leetcode;

public class CanPartitionKSubsets20210204 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum / k < 1 || sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return partitionRec(nums, k, target, 0, 0, used);
    }

    private boolean partitionRec(int[] nums, int k, int target, int currSum, int currIndex, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (currSum > target) {
            return false;
        }
        if (currSum == target) {
            return partitionRec(nums, k - 1, target, 0, 0, used);
        }
        for (int i = currIndex; i < nums.length; i++) {
            if (used[i] || currSum + nums[i] > target) {
                continue;
            }
            used[i] = true;
            if (partitionRec(nums, k, target, currSum + nums[i], i + 1, used)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}
