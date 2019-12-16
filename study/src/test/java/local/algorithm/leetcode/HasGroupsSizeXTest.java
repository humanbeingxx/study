package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class HasGroupsSizeXTest {

    @Test
    public void testHasGroupsSizeX1() {
        boolean result = new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        Assert.assertTrue(result);
    }

    @Test
    public void testHasGroupsSizeX2() {
        boolean result = new HasGroupsSizeX().hasGroupsSizeX(new int[]{3, 3, 3});
        Assert.assertTrue(result);
    }

    @Test
    public void testHasGroupsSizeX3() {
        boolean result = new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3});
        Assert.assertFalse(result);
    }

    @Test
    public void testHasGroupsSizeX4() {
        boolean result = new HasGroupsSizeX().hasGroupsSizeX(new int[]{1});
        Assert.assertFalse(result);
    }

    @Test
    public void testHasGroupsSizeX5() {
        boolean result = new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 1});
        Assert.assertTrue(result);
    }

    @Test
    public void testHasGroupsSizeX6() {
        boolean result = new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2});
        Assert.assertTrue(result);
    }

}