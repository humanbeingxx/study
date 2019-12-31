package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class MaxProfitII {

    public int maxProfit(int[] prices) {
        int low = -1, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int pre = prices[Math.max(0, i - 1)];
            int curr = prices[i];
            int next = prices[Math.min(prices.length - 1, i + 1)];
            if ((curr <= pre && curr < next) || (curr < pre && curr <= next)) {
                if (low < 0) {
                    low = curr;
                }
            } else if ((curr >= pre && curr > next) || (curr > pre && curr >= next)) {
                if (low >= 0) {
                    profit += curr - low;
                    low = -1;
                }
            }
        }
        return profit;
    }
}
