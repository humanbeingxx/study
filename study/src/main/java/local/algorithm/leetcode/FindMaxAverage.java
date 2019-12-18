package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 22:01
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        int max = currSum;

        if (nums.length == k) {
            return (double) max / k;
        }
        for (int i = k; i < nums.length; i++) {
            currSum = currSum + nums[i] - nums[i - k];
            if (currSum > max) {
                max = currSum;
            }
        }
        return (double) max / k;
    }
}
