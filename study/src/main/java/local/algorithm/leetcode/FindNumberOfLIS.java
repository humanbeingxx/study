package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 21:49
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lengths = new int[n];
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        Arrays.fill(lengths, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[j] == lengths[i] + 1) {
                        counts[j] += counts[i];
                    }
                } else if (nums[j] == nums[i]) {
                    if (lengths[j] == lengths[i]) {
                        counts[j] = counts[i];
                    } else if (lengths[j] < lengths[i]) {
                        counts[j] = counts[i];
                        lengths[j] = lengths[i];
                    }
                }
            }
        }

        int maxLen = 0;
        for (int length : lengths) {
            maxLen = Math.max(maxLen, length);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLen) {
                result += counts[i];
            }
        }
        return result;
    }
}
