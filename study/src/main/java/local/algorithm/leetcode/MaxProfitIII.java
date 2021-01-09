package local.algorithm.leetcode;

public class MaxProfitIII {

    public int maxProfit(int[] prices) {
        int[][] buy = new int[prices.length][3];
        int[][] sell = new int[prices.length][3];
        buy[0][0] = -prices[0];
        buy[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], -prices[i]);
        }
        for (int i = 1; i < prices.length; i++) {
            sell[i][1] = Math.max(sell[i - 1][1], buy[i - 1][0] + prices[i]);
            buy[i][1] = Math.max(buy[i - 1][1], sell[i - 1][1] - prices[i]);
            sell[i][2] = Math.max(sell[i - 1][2], buy[i - 1][1] + prices[i]);
        }
        return Math.max(sell[prices.length - 1][1], sell[prices.length - 1][2]);
    }
}
