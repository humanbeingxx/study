package local.algorithm.leetcode;

public class SumAbsoluteDifferences {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int preSum = 0, afterSum = 0;
        for (int num : nums) {
            afterSum += num;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            afterSum -= nums[i];
            if (i == 0) {
                result[i] = afterSum - nums[i] * (nums.length - 1);
            } else if (i == nums.length - 1) {
                result[i] = nums[i] * (nums.length - 1) - preSum;
            } else {
                result[i] = (nums[i] * i - preSum) + (afterSum - nums[i] * (nums.length - i - 1));
            }
            preSum += nums[i];
        }
        return result;
    }
}
