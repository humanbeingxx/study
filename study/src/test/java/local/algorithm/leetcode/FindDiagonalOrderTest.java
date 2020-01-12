package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/12 22:15
 */
public class FindDiagonalOrderTest {

    @Test
    public void testFindDiagonalOrder1() {
        int[] result = new FindDiagonalOrder().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertEquals(result, new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9});
    }

    @Test
    public void testFindDiagonalOrder2() {
        int[] result = new FindDiagonalOrder().findDiagonalOrder(new int[][]{{1}});
        assertEquals(result, new int[]{1});
    }

    @Test
    public void testFindDiagonalOrder3() {
        int[] result = new FindDiagonalOrder().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}});
        assertEquals(result, new int[]{1, 2, 4, 7, 5, 3, 6, 8, 10, 11, 9, 12});
    }

    @Test
    public void testFindDiagonalOrder4() {
        int[] result = new FindDiagonalOrder().findDiagonalOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        assertEquals(result, new int[]{1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12});
    }

    @Test
    public void testFindDiagonalOrder5() {
        int[] result = new FindDiagonalOrder().findDiagonalOrder(new int[][]{{1, 2, 3, 4}});
        assertEquals(result, new int[]{1, 2, 3, 4});
    }

    @Test
    public void testFindDiagonalOrder6() {
        int[] result = new FindDiagonalOrder().findDiagonalOrder(new int[][]{{1}, {2}, {3}, {4}});
        assertEquals(result, new int[]{1, 2, 3, 4});
    }

    @Test
    public void testFindDiagonalOrder7() {
        int[] result = new FindDiagonalOrder().findDiagonalOrder(new int[][]{{2, 5, 8}, {4, 0, -1}});
        assertEquals(result, new int[]{2, 5, 4, 0, 8, -1});
    }
}