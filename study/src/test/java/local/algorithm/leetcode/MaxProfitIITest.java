package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class MaxProfitIITest {

    @Test
    public void testMaxProfit() {
        int result = new MaxProfitII().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(result, 7);

        result = new MaxProfitII().maxProfit(new int[]{1, 2, 3, 4, 5});
        assertEquals(result, 4);

        result = new MaxProfitII().maxProfit(new int[]{5, 4, 3, 2, 1});
        assertEquals(result, 0);

        result = new MaxProfitII().maxProfit(new int[]{1});
        assertEquals(result, 0);

        result = new MaxProfitII().maxProfit(new int[]{1, 1, 1});
        assertEquals(result, 0);

        result = new MaxProfitII().maxProfit(new int[]{1, 1});
        assertEquals(result, 0);

        result = new MaxProfitII().maxProfit(new int[]{2, 1, 2, 0, 1});
        assertEquals(result, 2);
    }
}