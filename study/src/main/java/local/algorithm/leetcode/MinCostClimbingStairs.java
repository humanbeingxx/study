package local.algorithm.leetcode;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] totalCost = new int[cost.length + 1];
        totalCost[0] = 0;
        totalCost[1] = 0;
        for (int i = 2; i < totalCost.length; i++) {
            totalCost[i] = Math.min(totalCost[i - 1] + cost[i - 1], totalCost[i - 2] + cost[i - 2]);
        }
        return totalCost[totalCost.length - 1];
    }
}
