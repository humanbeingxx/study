package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class ProductExceptSelfTest {

    @Test
    public void testProductExceptSelf1() {
        int[] result = new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
        assertEquals(result, new int[]{24, 12, 8, 6});
    }

    @Test
    public void testProductExceptSelf2() {
        int[] result = new ProductExceptSelf().productExceptSelf(new int[]{1, 2});
        assertEquals(result, new int[]{2, 1});
    }
}