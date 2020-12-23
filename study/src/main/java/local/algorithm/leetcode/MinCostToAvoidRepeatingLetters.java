package local.algorithm.leetcode;

public class MinCostToAvoidRepeatingLetters {

    public int minCost(String s, int[] cost) {
        if (s.length() == 1) {
            return 0;
        }
        char prevC = s.charAt(0);
        int totalCost = 0, maxCost = 0, currTotalCost = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prevC) {
                if (currTotalCost == 0) {
                    currTotalCost = cost[i] + cost[i - 1];
                    maxCost = Math.max(cost[i - 1], cost[i]);
                } else {
                    currTotalCost += cost[i];
                    maxCost = Math.max(maxCost, cost[i]);
                }
            } else {
                totalCost += currTotalCost - maxCost;
                currTotalCost = 0;
                maxCost = 0;
                prevC = c;
            }
        }
        if (currTotalCost > 0) {
            totalCost += currTotalCost - maxCost;
        }
        return totalCost;
    }
}
