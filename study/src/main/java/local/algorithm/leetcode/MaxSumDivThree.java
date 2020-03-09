package local.algorithm.leetcode;

public class MaxSumDivThree {

    public int maxSumDivThree(int[] nums) {
        int[][] remains = new int[nums.length][3];
        remains[0][remain(nums[0])] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (remain(nums[i]) == 0) {
                remains[i][0] = remains[i - 1][0] + nums[i];
                if (remains[i - 1][1] > 0) {
                    remains[i][1] = remains[i - 1][1] + nums[i];
                } else {
                    remains[i][1] = remains[i - 1][1];
                }
                if (remains[i - 1][2] > 0) {
                    remains[i][2] = remains[i - 1][2] + nums[i];
                } else {
                    remains[i][2] = remains[i - 1][2];
                }
            } else if (remain(nums[i]) == 1) {
                if (remains[i - 1][2] > 0) {
                    remains[i][0] = Math.max(remains[i - 1][0], remains[i - 1][2] + nums[i]);
                } else {
                    remains[i][0] = remains[i - 1][0];
                }
                remains[i][1] = Math.max(remains[i - 1][1], remains[i - 1][0] + nums[i]);
                if (remains[i - 1][1] > 0) {
                    remains[i][2] = Math.max(remains[i - 1][2], remains[i - 1][1] + nums[i]);
                } else {
                    remains[i][2] = remains[i - 1][2];
                }
            } else {
                if (remains[i - 1][1] > 0) {
                    remains[i][0] = Math.max(remains[i - 1][0], remains[i - 1][1] + nums[i]);
                } else {
                    remains[i][0] = remains[i - 1][0];
                }
                if (remains[i - 1][2] > 0) {
                    remains[i][1] = Math.max(remains[i - 1][1], remains[i - 1][2] + nums[i]);
                } else {
                    remains[i][1] = remains[i - 1][1];
                }
                remains[i][2] = Math.max(remains[i - 1][2], remains[i - 1][0] + nums[i]);
            }
        }
        return remains[nums.length - 1][0];
    }

    private int remain(int num) {
        return (num % 3 + 3) % 3;
    }
}
