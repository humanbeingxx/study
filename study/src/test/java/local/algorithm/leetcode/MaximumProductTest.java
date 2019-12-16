package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 21:46
 */
public class MaximumProductTest {

    @Test
    public void testMaximumProduct1() {
        int result = new MaximumProduct().maximumProduct(new int[]{1, 2, 3, 4});
        Assert.assertEquals(result, 24);
    }

    @Test
    public void testMaximumProduct2() {
        int result = new MaximumProduct().maximumProduct(new int[]{});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testMaximumProduct3() {
        int result = new MaximumProduct().maximumProduct(new int[]{1, 2, -3, 4});
        Assert.assertEquals(result, 8);
    }

    @Test
    public void testMaximumProduct4() {
        int result = new MaximumProduct().maximumProduct(new int[]{1, -2, -3, 4});
        Assert.assertEquals(result, 24);
    }
}