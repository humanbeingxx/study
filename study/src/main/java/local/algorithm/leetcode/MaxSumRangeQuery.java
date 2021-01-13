package local.algorithm.leetcode;

import java.util.Arrays;

public class MaxSumRangeQuery {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] weights = new int[nums.length];
        for (int[] request : requests) {
            weights[request[0]]++;
            if (request[1] + 1 < nums.length) {
                weights[request[1] + 1]--;
            }
        }
        for (int i = 1; i < weights.length; i++) {
            weights[i] += weights[i - 1];
        }
        Arrays.sort(weights);
        Arrays.sort(nums);
        long sum = 0;
        for (int i = weights.length - 1; i >= 0 && weights[i] > 0; i--) {
            int weight = weights[i];
            int num = nums[i];
            sum += ((long) num) * weight;
        }
        return (int) (sum % 1000000007);
    }
}
