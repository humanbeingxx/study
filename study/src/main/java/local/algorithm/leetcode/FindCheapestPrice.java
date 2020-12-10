package local.algorithm.leetcode;

import java.util.Arrays;

public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) {
            return 0;
        }
        int[][] minCosts = new int[n][K + 2];
        for (int i = 0; i < n; i++) {
            if (i == src) {
                Arrays.fill(minCosts[i], 0);
            } else {
                Arrays.fill(minCosts[i], Integer.MAX_VALUE);
            }
        }
        for (int i = 1; i <= K + 1; i++) {
            for (int[] flight : flights) {
                int start = flight[0], end = flight[1], cost = flight[2];
                if (minCosts[start][i - 1] != Integer.MAX_VALUE) {
                    minCosts[end][i] = Math.min(minCosts[end][i], minCosts[start][i - 1] + cost);
                }
            }
        }
        return minCosts[dst][K + 1] == Integer.MAX_VALUE ? - 1:minCosts[dst][K + 1];
    }

}
