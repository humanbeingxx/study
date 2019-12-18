package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num != 1) {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 0;
            } else {
                currentCount++;
            }
        }
        if (currentCount > maxCount) {
            maxCount = currentCount;
        }
        return maxCount;
    }
}
