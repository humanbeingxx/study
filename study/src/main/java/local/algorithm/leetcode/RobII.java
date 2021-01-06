package local.algorithm.leetcode;

import java.util.Arrays;

public class RobII {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] amounts = new int[nums.length];
        int max = 0;
        amounts[0] = nums[0];
        amounts[1] = nums[1];
        max = Math.max(amounts[0], amounts[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            amounts[i] = Math.max(nums[i] + amounts[i - 2], amounts[i - 1]);
            if (amounts[i] > max) {
                max = amounts[i];
            }
        }

        Arrays.fill(amounts, 0);
        amounts[0] = 0;
        amounts[1] = nums[1];
        amounts[2] = nums[2];
        max = Math.max(max, Math.max(amounts[1], amounts[2]));
        for (int i = 3; i < nums.length; i++) {
            amounts[i] = Math.max(nums[i] + amounts[i - 2], amounts[i - 1]);
            if (amounts[i] > max) {
                max = amounts[i];
            }
        }
        return max;
    }
}
