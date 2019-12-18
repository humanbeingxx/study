package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 22:14
 */
public class PowerOfFourTest {

    @Test
    public void testIsPowerOfFour() {
        boolean result = new PowerOfFour().isPowerOfFour(4);
        Assert.assertTrue(result);

        result = new PowerOfFour().isPowerOfFour(1);
        Assert.assertTrue(result);

        result = new PowerOfFour().isPowerOfFour(-1);
        Assert.assertFalse(result);

        result = new PowerOfFour().isPowerOfFour(5);
        Assert.assertFalse(result);

        result = new PowerOfFour().isPowerOfFour(8);
        Assert.assertFalse(result);
    }
}