package local.algorithm.leetcode;

import java.util.Arrays;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o2[1] - o2[0] - (o1[1] - o1[0]));
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            cost += costs[i][1];
        }
        return cost;
    }
}
