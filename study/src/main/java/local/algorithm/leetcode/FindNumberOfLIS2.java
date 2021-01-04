package local.algorithm.leetcode;

import java.util.Arrays;

public class FindNumberOfLIS2 {

    public int findNumberOfLIS(int[] nums) {
        int[] counts = new int[nums.length];
        int[] lens = new int[nums.length];
        Arrays.fill(counts, 1);
        Arrays.fill(lens, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int newLen = lens[j] + 1;
                    if (newLen > lens[i]) {
                        lens[i] = newLen;
                        counts[i] = counts[j];
                    } else if (newLen == lens[i]) {
                        counts[i] += counts[j];
                    }
                } else if (nums[i] == nums[j]) {
                    if (lens[j] >= lens[i]) {
                        lens[i] = lens[j];
                        counts[i] = counts[j];
                    }
                }
            }
        }

        int maxLen = 1;
        for (int len : lens) {
            if (len > maxLen) {
                maxLen = len;
            }
        }
        int total = 0;
        for (int i = 0; i < lens.length; i++) {
            if (lens[i] == maxLen) {
                total += counts[i];
            }
        }
        return total;
    }
}
