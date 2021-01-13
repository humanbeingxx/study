package local.algorithm.leetcode;

public class MinOperationsToTargetArray {

    public int minOperations(int[] nums) {
        int plusCount = 0, maxMultiCount = 0, multiCount = 0;
        for (int num : nums) {
            multiCount = 0;
            while (num > 0) {
                if ((num & 1) == 0) {
                    num >>= 1;
                    multiCount++;
                } else {
                    num--;
                    plusCount++;
                }
                maxMultiCount = Math.max(maxMultiCount, multiCount);
            }
        }
        return plusCount + maxMultiCount;
    }
}
