package local.algorithm.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int minSub = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int sub = sumClosest(nums, i + 1, target - nums[i]);
            if (Math.abs(sub) < Math.abs(minSub)) {
                minSub = sub;
            }
        }
        return target - minSub;
    }

    int sumClosest(int[] nums, int start, int target) {
        int minSub = Integer.MAX_VALUE;
        int end = nums.length - 1;
        while (start < end) {
            int sub = target - (nums[start] + nums[end]);
            if (sub == 0) {
                return 0;
            }
            if (Math.abs(sub) < Math.abs(minSub)) {
                minSub = sub;
            }
            if (sub > 0) {
                start++;
            } else {
                end--;
            }
        }
        return minSub;
    }
}
