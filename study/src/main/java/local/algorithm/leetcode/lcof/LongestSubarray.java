package local.algorithm.leetcode.lcof;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/11 16:00
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 0, currLen = 0, currMax = nums[0], currMin = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (inBoundary(curr, currMax, limit) && inBoundary(curr, currMin, limit)) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
                if (curr > currMax) {
                    currMax = curr;
                } else if (curr < currMin) {
                    currMin = curr;
                }
            } else {
                currLen = 1;
                if (curr > currMax) {
                    currMax = curr;
                    currMin = curr;
                    for (int j = i - 1; j >= 0; j--) {
                        int preVal = nums[j];
                        if (inBoundary(preVal, currMax, limit)) {
                            currMin = Math.min(currMin, preVal);
                            currLen++;
                        } else {
                            break;
                        }
                    }
                } else if (curr < currMin) {
                    currMin = curr;
                    currMax = curr;
                    for (int j = i - 1; j >= 0; j--) {
                        int preVal = nums[j];
                        if (inBoundary(preVal, currMin, limit)) {
                            currMax = Math.max(currMax, preVal);
                            currLen++;
                        } else {
                            break;
                        }
                    }
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }

    private boolean inBoundary(int val1, int val2, int limit) {
        return Math.abs(val1 - val2) <= limit;
    }
}
