package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CanReachZeroTest {

    @Test
    public void testCanReach1() {
        boolean result = new CanReachZero().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5);
        assertTrue(result);
    }

    @Test
    public void testCanReach2() {
        boolean result = new CanReachZero().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0);
        assertTrue(result);
    }

    @Test
    public void testCanReach3() {
        boolean result = new CanReachZero().canReach(new int[]{3, 0, 2, 1, 2}, 2);
        assertFalse(result);
    }
}