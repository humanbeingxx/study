package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/27 16:09
 */
public class OrangesRotting2Test {

    @Test
    public void testOrangesRotting() {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result = new OrangesRotting2().orangesRotting(grid);
        assertEquals(result, 4);
    }

    @Test
    public void testOrangesRotting2() {
        int[][] grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int result = new OrangesRotting2().orangesRotting(grid);
        assertEquals(result, -1);
    }


    @Test
    public void testOrangesRotting3() {
        int[][] grid = new int[][]{{0, 2}};
        int result = new OrangesRotting2().orangesRotting(grid);
        assertEquals(result, 0);
    }
}