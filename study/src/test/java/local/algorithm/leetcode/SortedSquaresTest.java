package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class SortedSquaresTest {

    @Test
    public void testSortedSquares() {
        int[] result = new SortedSquares().sortedSquares(new int[]{-4, -1, 0, 3, 10});
        assertEquals(result, new int[]{0, 1, 9, 16, 100});

        result = new SortedSquares().sortedSquares(new int[]{1, 1, 1, 1, 1});
        assertEquals(result, new int[]{1, 1, 1, 1, 1});

        result = new SortedSquares().sortedSquares(new int[]{-7, -3, 2, 3, 11});
        assertEquals(result, new int[]{4, 9, 9, 49, 121});

        result = new SortedSquares().sortedSquares(new int[]{-7});
        assertEquals(result, new int[]{49});
    }
}