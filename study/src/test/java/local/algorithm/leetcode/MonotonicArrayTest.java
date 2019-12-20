package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class MonotonicArrayTest {

    @Test
    public void testIsMonotonic() {
        boolean result = new MonotonicArray().isMonotonic(new int[]{1,2,2,3});
        Assert.assertTrue(result);
        result = new MonotonicArray().isMonotonic(new int[]{4,3,3,3});
        Assert.assertTrue(result);
        result = new MonotonicArray().isMonotonic(new int[]{1,1,1});
        Assert.assertTrue(result);
        result = new MonotonicArray().isMonotonic(new int[]{});
        Assert.assertTrue(result);

        result = new MonotonicArray().isMonotonic(new int[]{1,3,2,3,2});
        Assert.assertFalse(result);
    }
}