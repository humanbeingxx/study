package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class OddCellsTest {

    @Test
    public void testOddCells() {
        int result = new OddCells().oddCells(2, 3, new int[][]{{0, 1}, {1, 1}});
        assertEquals(result, 6);
    }
}