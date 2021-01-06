package local.algorithm.leetcode;

public class MaxProfitWithFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0, curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            } else if (prices[i] - curMin > fee) {
                profit += prices[i] - curMin - fee;
                curMin = prices[i] - fee;
            }
        }
        return profit;
    }
}
