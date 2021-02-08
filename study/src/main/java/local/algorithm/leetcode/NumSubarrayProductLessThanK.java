package local.algorithm.leetcode;

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0;
        int product = 1, count = 0;
        for (; end < nums.length; end++) {
            product *= nums[end];
            if (product < k) {
                count++;
            } else {
                while (start <= end && product >= k) {
                    product /= nums[start++];
                }
                if (start <= end) {
                    count++;
                }
            }
        }
        return count;
    }
}
