package local.algorithm.leetcode;

public class MinMovesToMakeArrayComplementary {

    public int minMoves(int[] nums, int limit) {
        int[] possibles = new int[2 * limit + 2];
        for (int i = 0; i < nums.length / 2; i++) {
            int low = 2, high = 2 * limit;
            possibles[low] += 2;
            possibles[high + 1] -= 2;
            low = 1 + Math.min(nums[i], nums[nums.length - i - 1]);
            high = Math.max(nums[i], nums[nums.length - i - 1]) + limit;
            possibles[low] -= 1;
            possibles[high + 1] += 1;
            low = high = nums[i] + nums[nums.length - i - 1];
            possibles[low] -= 1;
            possibles[high + 1] += 1;
        }
        int currSum = 0, min = nums.length;
        for (int i = 2; i <= 2 * limit; i++) {
            currSum += possibles[i];
            min = Math.min(currSum, min);
        }
        return min;
    }
}
