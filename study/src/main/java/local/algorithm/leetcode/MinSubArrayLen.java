package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0 || nums == null || nums.length == 0) {
            return 0;
        }
        int headIndex = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i - headIndex + 1);
                sum -= nums[headIndex++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
