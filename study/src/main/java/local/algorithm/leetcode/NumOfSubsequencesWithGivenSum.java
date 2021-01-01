package local.algorithm.leetcode;

import java.util.Arrays;

public class NumOfSubsequencesWithGivenSum {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long count = 0;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else {
                count += Math.pow(2, end - start);
                start++;
            }
        }

        return (int) (count % (Math.pow(10, 9) + 7));
    }
}
