package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class FindHarmonic {

    public int findLHS(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLen = 0;
        int firstValue = nums[0], secondValue = nums[0], firstStart = 0, secondStart = 0;
        int i = 1;
        for (; i < nums.length; i++) {
            int preNum = nums[i - 1];
            int currNum = nums[i];
            if (preNum == currNum) {
                if (secondValue - firstValue == 1) {
                    maxLen = Math.max(i - firstStart, maxLen);
                }
            } else if (currNum - preNum == 1) {
                if (secondValue - firstValue == 1) {
                    maxLen = Math.max(i - firstStart, maxLen);
                }
                firstStart = secondStart;
                secondStart = i;
                firstValue = secondValue;
                secondValue = currNum;
            } else {
                if (secondValue - firstValue == 1) {
                    maxLen = Math.max(i - firstStart, maxLen);
                }
                firstStart = i;
                secondStart = i;
                firstValue = currNum;
                secondValue = currNum;
            }
        }
        if (secondValue - firstValue == 1) {
            maxLen = Math.max(i - firstStart, maxLen);
        }

        return maxLen;
    }
}
