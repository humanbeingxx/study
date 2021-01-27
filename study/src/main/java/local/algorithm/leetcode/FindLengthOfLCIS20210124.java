package local.algorithm.leetcode;

public class FindLengthOfLCIS20210124 {

    public int findLengthOfLCIS(int[] nums) {
        int max = 1, currLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                currLen = 1;
            } else {
                currLen++;
            }
            max = Math.max(currLen, max);
        }
        return max;
    }
}
