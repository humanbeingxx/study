package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:43
 */
public class ClimbStairsTest {

    @Test
    public void testClimbStairs() {
        int result = new ClimbStairs().climbStairs(3);
        assertEquals(result, 3);

        result = new ClimbStairs().climbStairs(10);
        assertEquals(result, 89);
    }
}