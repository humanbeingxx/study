package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] count = new int[max + 1];
        int[] start = new int[max + 1];
        int[] end = new int[max + 1];

        int maxCount = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            int num = nums[i - 1];
            count[num]++;
            if (start[num] == 0) {
                start[num] = i;
            }
            end[num] = i;
            if (count[num] > maxCount) {
                maxCount = count[num];
            }
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i <= max; i++) {
            if (count[i] != maxCount) {
                continue;
            }
            int len = end[i] - start[i];
            if (len < minLen) {
                minLen = len;
            }
        }
        return minLen + 1;
    }
}
