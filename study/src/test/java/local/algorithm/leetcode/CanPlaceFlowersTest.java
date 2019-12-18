package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class CanPlaceFlowersTest {

    @Test
    public void testCanPlaceFlowers() {
        boolean result = new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
        Assert.assertTrue(result);

        result = new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2);
        Assert.assertFalse(result);

        result = new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0}, 1);
        Assert.assertTrue(result);

        result = new CanPlaceFlowers().canPlaceFlowers(new int[]{0}, 1);
        Assert.assertTrue(result);

        result = new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0, 0}, 2);
        Assert.assertTrue(result);

        result = new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0, 0}, 3);
        Assert.assertFalse(result);
    }
}