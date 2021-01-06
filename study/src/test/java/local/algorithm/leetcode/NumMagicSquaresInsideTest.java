package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 21:21
 */
public class NumMagicSquaresInsideTest {

    @Test
    public void testCheck() {

        int[][] data = new int[][]{{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};

        boolean check = new NumMagicSquaresInside().check(data, 0, 0);

        Assert.assertTrue(check);
    }

    @Test
    public void testNumMagicSquaresInside() {
        int[][] data = new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};

        int count = new NumMagicSquaresInside().numMagicSquaresInside(data);

        Assert.assertEquals(count, 1);
    }

    @Test
    public void testNumMagicSquaresInside2() {
        int[][] data = new int[][]{{5, 5, 5}, {5, 5, 5}, {5, 5, 5}};

        int count = new NumMagicSquaresInside().numMagicSquaresInside(data);

        Assert.assertEquals(count, 0);
    }

    @Test
    public void testNumMagicSquaresInside3() {
        int[][] data = new int[][]{{5, 4, 7, 8, 5, 4, 6, 8, 2, 9}, {5, 3, 6, 8, 1, 5, 1, 1, 8, 5}, {8, 9, 6, 8, 4, 7, 3, 4, 9, 1},
                {9, 3, 8, 9, 2, 8, 3, 8, 7, 1}, {1, 1, 1, 7, 3, 3, 9, 1, 8, 7}, {1, 5, 5, 7, 1, 6, 7, 9, 3, 4}, {2, 3, 3, 8, 8, 1, 1, 6, 5, 7},
                {7, 8, 5, 4, 7, 9, 4, 6, 5, 3}, {8, 5, 2, 7, 1, 3, 7, 2, 8, 9}, {4, 9, 4, 3, 9, 4, 5, 4, 7, 1}};

        int count = new NumMagicSquaresInside().numMagicSquaresInside(data);

        Assert.assertEquals(count, 0);
    }
}