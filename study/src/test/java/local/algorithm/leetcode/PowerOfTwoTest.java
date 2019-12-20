package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/20 23:52
 */
public class PowerOfTwoTest {

    @Test
    public void testIsPowerOfTwo() {
        boolean result = new PowerOfTwo().isPowerOfTwo(1);
        assertTrue(result);

        result = new PowerOfTwo().isPowerOfTwo(16);
        assertTrue(result);

        result = new PowerOfTwo().isPowerOfTwo(128);
        assertTrue(result);

        result = new PowerOfTwo().isPowerOfTwo(4096);
        assertTrue(result);

        result = new PowerOfTwo().isPowerOfTwo(65536);
        assertTrue(result);

        result = new PowerOfTwo().isPowerOfTwo(536870912);
        assertTrue(result);

        result = new PowerOfTwo().isPowerOfTwo(218);
        assertFalse(result);

    }
}