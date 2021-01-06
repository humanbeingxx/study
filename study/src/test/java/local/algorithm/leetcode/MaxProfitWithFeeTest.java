package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaxProfitWithFeeTest {

    @Test
    public void testMaxProfit1() {
        int result = new MaxProfitWithFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        assertEquals(result, 8);
    }

    @Test
    public void testMaxProfit2() {
        int result = new MaxProfitWithFee().maxProfit(new int[]{1, 3, 2, 8, 4, 5}, 2);
        assertEquals(result, 5);
    }

    @Test
    public void testMaxProfit3() {
        int result = new MaxProfitWithFee().maxProfit(new int[]{1, 3, 5, 7, 9}, 2);
        assertEquals(result, 6);
    }

    @Test
    public void testMaxProfit4() {
        int result = new MaxProfitWithFee().maxProfit(new int[]{1, 4}, 2);
        assertEquals(result, 1);
    }

    @Test
    public void testMaxProfit5() {
        int result = new MaxProfitWithFee().maxProfit(new int[]{1, 3}, 2);
        assertEquals(result, 0);
    }

    @Test
    public void testMaxProfit6() {
        int result = new MaxProfitWithFee().maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
        assertEquals(result, 6);
    }

    @Test
    public void testMaxProfit7() {
        int result = new MaxProfitWithFee().maxProfit(new int[]{2, 1, 4, 4, 2, 3, 2, 5, 1, 2}, 1);
        assertEquals(result, 4);
    }
}