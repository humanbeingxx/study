package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int subSum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            subSum += nums[i];
            result.add(nums[i]);
            if (subSum > sum - subSum) {
                break;
            }
        }
        return result;
    }
}
