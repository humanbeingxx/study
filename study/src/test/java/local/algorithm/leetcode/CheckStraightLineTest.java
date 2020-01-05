package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:47
 */
public class CheckStraightLineTest {

    @Test
    public void testCheckStraightLine() {
        boolean result = new CheckStraightLine().checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}});
        assertTrue(result);

        result = new CheckStraightLine().checkStraightLine(new int[][]{{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}});
        assertTrue(result);
    }
}