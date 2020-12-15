package local.algorithm.leetcode;

import java.util.Arrays;

public class SpecialArray {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            if (i <= nums[nums.length - i] && (i == nums.length || i > nums[nums.length - i - 1])) {
                return i;
            }
        }
        return -1;
    }
}
