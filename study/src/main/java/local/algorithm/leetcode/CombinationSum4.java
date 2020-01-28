package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] summed = new int[target + 1];
        summed[0] = 1;
        for (int i = 1; i <= target; i++) {
            int canReach = 0;
            for (int num : nums) {
                if (i >= num) {
                    canReach += summed[i - num];
                }
            }
            summed[i] = canReach;
        }
        return summed[target];
    }

}