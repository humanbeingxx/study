package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/17 22:15
 */
public class HappyNumberTest {

    @Test
    public void testCalcNext() {
        int result = new HappyNumber().calcNext(100);
        Assert.assertEquals(result, 1);

        result = new HappyNumber().calcNext(19);
        Assert.assertEquals(result, 82);

        result = new HappyNumber().calcNext(68);
        Assert.assertEquals(result, 100);
    }

    @Test
    public void testIsHappy() {
        boolean result = new HappyNumber().isHappy(19);
        Assert.assertTrue(result);

        result = new HappyNumber().isHappy(18);
        Assert.assertFalse(result);

        result = new HappyNumber().isHappy(1);
        Assert.assertTrue(result);
    }
}