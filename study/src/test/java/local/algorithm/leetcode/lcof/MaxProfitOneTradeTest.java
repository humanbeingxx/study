package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/11 15:42
 */
public class MaxProfitOneTradeTest {

    @Test
    public void testMaxProfit1() {
        int result = new MaxProfitOneTrade().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(result, 5);
    }

    @Test
    public void testMaxProfit2() {
        int result = new MaxProfitOneTrade().maxProfit(new int[]{7, 6, 4, 3, 1});
        assertEquals(result, 0);
    }
}