package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/4 13:34
 */
public class OrangesRottingTest {

    @Test
    public void testOrangesRotting() {
        int result = new OrangesRotting().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        assertEquals(result, 4);

        result = new OrangesRotting().orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}});
        assertEquals(result, -1);

        result = new OrangesRotting().orangesRotting(new int[][]{{0, 2}});
        assertEquals(result, 0);
    }
}