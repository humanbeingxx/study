package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, currMax = 1, currMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = currMax;
                currMax = Math.max(num, currMin * num);
                currMin = Math.min(num, temp * num);
            } else {
                currMax = Math.max(num, currMax * num);
                currMin = Math.min(num, currMin * num);
            }
            max = Math.max(currMax, max);
        }
        return max;
    }
}
