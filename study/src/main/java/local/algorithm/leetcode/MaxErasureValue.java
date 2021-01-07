package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        int start = 0, currentIndex = 0, sum = 0, maxSum = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        Map<Integer, Integer> indices = new HashMap<>();
        while (currentIndex < nums.length) {
            if (indices.containsKey(nums[currentIndex]) && indices.get(nums[currentIndex]) >= start) {
                start = indices.get(nums[currentIndex]) + 1;
                maxSum = Math.max(sums[currentIndex] - sums[start - 1], maxSum);
            } else {
                maxSum = Math.max(start == 0 ? sums[currentIndex] : sums[currentIndex] - sums[start - 1], maxSum);
            }
            indices.put(nums[currentIndex], currentIndex);
            currentIndex++;
        }
        return maxSum;
    }
}
