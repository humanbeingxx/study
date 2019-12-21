package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 21:40
 */
public class IsRectangleOverlapTest {

    @Test
    public void testIsRectangleOverlap() {
        boolean result = new IsRectangleOverlap().isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3});
        assertTrue(result);

        result = new IsRectangleOverlap().isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20});
        assertTrue(result);

        result = new IsRectangleOverlap().isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1});
        assertFalse(result);
    }
}