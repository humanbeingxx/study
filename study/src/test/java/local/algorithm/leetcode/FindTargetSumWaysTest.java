package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class FindTargetSumWaysTest {

    @Test
    public void testFindTargetSumWays1() {
        int result = new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        assertEquals(result, 5);
    }

    @Test
    public void testFindTargetSumWays2() {
        int result = new FindTargetSumWays().findTargetSumWays(new int[]{1, 2, 3, 4, 5, 6}, 15);
        assertEquals(result, 2);
    }
}