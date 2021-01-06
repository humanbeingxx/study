package local.algorithm.leetcode;

public class MaxProfitWithFrozen {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] buyProfit = new int[prices.length];
        int[] sellProfit = new int[prices.length];
        int[] frozeProfit = new int[prices.length];
        buyProfit[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            sellProfit[i] = Math.max(buyProfit[i - 1] + price, sellProfit[i - 1]);
            buyProfit[i] = Math.max(sellProfit[i - 1] - price, buyProfit[i - 1]);
            frozeProfit[i] = Math.max(frozeProfit[i - 1], Math.max(sellProfit[i - 1], buyProfit[i - 1]));
        }
        return sellProfit[prices.length - 1];
    }
}
