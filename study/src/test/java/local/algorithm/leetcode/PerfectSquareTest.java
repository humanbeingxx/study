package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class PerfectSquareTest {

    @Test
    public void testIsPerfectSquare() {

    }

    @Test
    public void testIsPerfectSquare3() {
        boolean result = new PerfectSquare().isPerfectSquare3(16);
        assertTrue(result);

        result = new PerfectSquare().isPerfectSquare3(14);
        assertFalse(result);

        result = new PerfectSquare().isPerfectSquare3(Integer.MAX_VALUE);
        assertFalse(result);
    }
}