package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000) {
            return 0;
        }
        int[][] sums = new int[nums.length][2001];
        sums[0][nums[0] + 1000] = 1;
        sums[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int[] preSums = sums[i - 1];
            for (int j = num - 1000; j <= 1000 - num; j++) {
                sums[i][num + j + 1000] += preSums[j + 1000];
                sums[i][-num + j + 1000] += preSums[j + 1000];
            }
        }

        return sums[nums.length - 1][S + 1000];
    }

}
