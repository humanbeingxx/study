package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class NumArray {

    private int[] partialSum;

    public NumArray(int[] nums) {
        partialSum = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        int currSum = nums[0];
        partialSum[0] = currSum;
        for (int i = 1; i < nums.length; i++) {
            currSum += nums[i];
            partialSum[i] = currSum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return partialSum[j];
        }
        return partialSum[j] - partialSum[i - 1];
    }
}
