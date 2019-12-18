package local.algorithm.leetcode;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class MaxProfitTest {

    @Test
    public void testMaxProfit() {
        int result = new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(result, 5);

        result = new MaxProfit().maxProfit(new int[]{7,6,4,3,1});
        Assert.assertEquals(result, 0);

        result = new MaxProfit().maxProfit(new int[]{7});
        Assert.assertEquals(result, 0);

        result = new MaxProfit().maxProfit(new int[]{});
        Assert.assertEquals(result, 0);
    }
}