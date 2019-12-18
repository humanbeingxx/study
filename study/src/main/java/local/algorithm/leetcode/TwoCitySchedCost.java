package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/17 21:58
 */
public class TwoCitySchedCost {

    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        for (int[] cost : costs) {
            sum += cost[1];
        }
        int[] diffAB = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            diffAB[i] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(diffAB);
        for (int i = 0; i < costs.length / 2; i++) {
            sum += diffAB[i];
        }

        return sum;
    }
}
