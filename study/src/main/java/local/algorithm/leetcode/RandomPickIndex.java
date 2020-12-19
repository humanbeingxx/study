package local.algorithm.leetcode;

import java.util.Random;

public class RandomPickIndex {

    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int happenCount = 0;
        int resultIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == target) {
                happenCount++;
                int ranInt = random.nextInt(happenCount);
                if (ranInt == 0) {
                    resultIndex = i;
                }
            }
        }
        return resultIndex;
    }
}
