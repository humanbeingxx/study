package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-07
 **/
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxLens = new int[nums.length];
        maxLens[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int max = 0, curr;
            for (int j = i + 1; j < nums.length; j++) {
                curr = nums[j] > nums[i] ? maxLens[j] + 1 : 1;
                if (curr > max) {
                    max = curr;
                }
            }
            maxLens[i] = max;
        }
        int max = 0;
        for (int len : maxLens) {
            if (len > max) {
                max = len;
            }
        }
        return max;
    }
}
