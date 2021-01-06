package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 21:42
 */
public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int preStart = 0, preEnd = 0;
        int start = 0, end = 0, maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                end++;
                if (end - start + 1 > maxLen) {
                    preStart = start;
                    preEnd = end;
                    maxLen = end - start + 1;
                }
            } else {
                start = i;
                end = i;
            }
        }
        return preEnd - preStart + 1;
    }
}
