package local.algorithm.leetcode;

import java.util.Arrays;

public class MinSumOfLengths1477 {

    public int minSumOfLengths(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, arr.length + 1);
        int start = 0, end = 0, sum = 0;
        while (end < arr.length) {
            sum += arr[end];
            while (start < end && sum > target) {
                sum -= arr[start++];
            }
            if (sum == target) {
                dp[end] = end - start + 1;
                if (start > 0) {
                    min = Math.min(min, end - start + 1 + dp[start - 1]);
                }
            }
            if (end > 0) {
                dp[end] = Math.min(dp[end], dp[end-1]);
            }
            end++;
        }
        return min > arr.length ? -1 : min;
    }
}
