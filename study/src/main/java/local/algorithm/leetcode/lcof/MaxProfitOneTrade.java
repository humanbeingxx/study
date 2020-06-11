package local.algorithm.leetcode.lcof;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/11 15:39
 */
public class MaxProfitOneTrade {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int currMax = prices[0], currMin = prices[0], maxProfit = 0;
        for (int price : prices) {
            if (price > currMax) {
                currMax = price;
                maxProfit = Math.max(maxProfit, currMax - currMin);
            } else if (price < currMin) {
                currMax = price;
                currMin = price;
            }
        }
        return maxProfit;
    }
}
