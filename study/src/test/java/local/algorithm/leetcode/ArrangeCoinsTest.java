package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/4 13:58
 */
public class ArrangeCoinsTest {

    @Test
    public void testArrangeCoins() {
        int result = new ArrangeCoins().arrangeCoins(2);
        assertEquals(result, 1);

        result = new ArrangeCoins().arrangeCoins(1804289383);
        assertEquals(result, 60070);
    }
}