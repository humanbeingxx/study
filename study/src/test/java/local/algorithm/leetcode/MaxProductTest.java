package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class MaxProductTest {

    @Test
    public void testMaxProduct1() {
        int result = new MaxProduct().maxProduct(new int[]{2, 3, -2, 4});
        assertEquals(result, 6);
    }

    @Test
    public void testMaxProduct2() {
        int result = new MaxProduct().maxProduct(new int[]{-1, 0, -2});
        assertEquals(result, 0);
    }

    @Test
    public void testMaxProduct3() {
        int result = new MaxProduct().maxProduct(new int[]{-1});
        assertEquals(result, -1);
    }

    @Test
    public void testMaxProduct4() {
        int result = new MaxProduct().maxProduct(new int[]{3, -1, 4});
        assertEquals(result, 4);
    }
}