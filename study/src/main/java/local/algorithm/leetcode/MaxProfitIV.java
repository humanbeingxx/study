package local.algorithm.leetcode;

public class MaxProfitIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        k = Math.min(k, prices.length / 2);
        Integer[][] buy = new Integer[prices.length][k + 1];
        Integer[][] sell = new Integer[prices.length][k + 1];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                buy[i][j] = 0;
                sell[i][j] = 0;
            }
        }
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i][0] = max(buy[i - 1][0], sell[i - 1][0] == null ? null : sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                sell[i][j] = max(sell[i - 1][j], buy[i - 1][j - 1] == null ? null : buy[i - 1][j - 1] + prices[i]);
                buy[i][j] = max(buy[i - 1][j], sell[i - 1][j] == null ? null : sell[i - 1][j] - prices[i]);
            }
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            max = max(max, sell[prices.length - 1][i]);
        }
        return max;
    }

    private Integer max(Integer a, Integer b) {
        if (a != null && b != null) {
            return Math.max(a, b);
        } else if (a != null) {
            return a;
        } else {
            return b;
        }
    }
}
