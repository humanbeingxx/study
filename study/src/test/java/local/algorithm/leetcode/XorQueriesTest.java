package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/8 19:45
 */
public class XorQueriesTest {

    @Test
    public void testXorQueries() {
        int[] result = new XorQueries().xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        assertEquals(result, new int[]{2, 7, 14, 8});
    }
}