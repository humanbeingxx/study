package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class ValidMountainArrayTest {

    @Test
    public void testValidMountainArray() {
        boolean result = new ValidMountainArray().validMountainArray(new int[]{0, 3, 2, 1});
        Assert.assertTrue(result);

        result = new ValidMountainArray().validMountainArray(new int[]{1, 2, 3, 2, 1, 2, 3});
        Assert.assertFalse(result);

        result = new ValidMountainArray().validMountainArray(new int[]{2, 1});
        Assert.assertFalse(result);

        result = new ValidMountainArray().validMountainArray(new int[]{3, 5, 5});
        Assert.assertFalse(result);

        result = new ValidMountainArray().validMountainArray(new int[]{1, 2, 5});
        Assert.assertFalse(result);

        result = new ValidMountainArray().validMountainArray(new int[]{5, 2, 1});
        Assert.assertFalse(result);
    }
}