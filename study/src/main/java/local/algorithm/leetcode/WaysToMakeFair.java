package local.algorithm.leetcode;

public class WaysToMakeFair {

    public int waysToMakeFair(int[] nums) {
        int[] preOddSum = new int[nums.length], preEvenSum = new int[nums.length];
        int[] postOddSum = new int[nums.length], postEvenSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                preEvenSum[i] = preEvenSum[i - 1];
                preOddSum[i] = preOddSum[i - 1] + nums[i - 1];
            } else {
                preEvenSum[i] = preEvenSum[i - 1] + nums[i - 1];
                preOddSum[i] = preOddSum[i - 1];
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i % 2 == 0) {
                postOddSum[i] = postOddSum[i + 1] + nums[i + 1];
                postEvenSum[i] = postEvenSum[i + 1];
            } else {
                postOddSum[i] = postOddSum[i + 1];
                postEvenSum[i] = postEvenSum[i + 1] + nums[i + 1];
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preOddSum[i] + postEvenSum[i] == preEvenSum[i] + postOddSum[i]) {
                count++;
            }
        }
        return count;
    }
}
