package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchRotatedArrayTest {

    @Test
    public void testSearch1() {
        int result = new SearchRotatedArray().search(new int[]{1, 1, 1, 1, 3, 3, 3, 4, 5, 6}, 2);
        assertEquals(result, -1);
    }

    @Test
    public void testSearch2() {
        int result = new SearchRotatedArray().search(new int[]{3, 4, 4, 5, 1, 2, 3, 3}, 4);
        assertEquals(result, 1);
    }

    @Test
    public void testSearch3() {
        int result = new SearchRotatedArray().search(new int[]{3, 4, 5, 1, 2, 3, 3}, -1);
        assertEquals(result, -1);
    }

    @Test
    public void testSearch4() {
        int result = new SearchRotatedArray().search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5);
        assertEquals(result, 8);
    }

    @Test
    public void testSearch5() {
        int result = new SearchRotatedArray().search(new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1}, 2);
        assertEquals(result, 5);
    }

    @Test
    public void testSearch6() {
        int result = new SearchRotatedArray().search(new int[]{1, 4, 4, 5, 5, 12, 17, 17, 20, 20, 21, 22, 22, 24, 24, 27, 29, 30, 32, 41, 41, 45, 45, 46, 47, 49, 53, 57, 57, 63, 63, -63, -63, -62, -56, -52, -48, -47, -44, -43, -43, -42, -41, -39, -39, -37, -34, -33, -32, -32, -29, -26, -25, -23, -16, -13, -11, -8, -7, -7, -6, -4, -2, -2}, -23);
        assertEquals(result, 53);
    }

    @Test
    public void testSearch7() {
        int result = new SearchRotatedArray().search(new int[]{1, -2}, -2);
        assertEquals(result, 1);
    }

    @Test
    public void testSearch8() {
        int result = new SearchRotatedArray().search(new int[]{5, 5, 5, 1, 2, 3, 4, 5}, 5);
        assertEquals(result, 0);
    }

    @Test
    public void testSearch9() {
        int result = new SearchRotatedArray().search(new int[]{2, 1, 2, 2, 2}, 2);
        assertEquals(result, 0);
    }

    @Test
    public void testSearch11() {
        int res = new SearchRotatedArray().search(new int[]{1, 2, 3, 3, 5, 6, 6, 6}, 0, 7, 6);
        assertEquals(res, 5);
    }

    @Test
    public void testSearch12() {
        int res = new SearchRotatedArray().search(new int[]{1, 2, 3, 3, 5, 6, 6, 6}, 0, 7, 4);
        assertEquals(res, -1);
    }

    @Test
    public void testSearch13() {
        int res = new SearchRotatedArray().search(new int[]{1, 2, 3, 3}, 0, 3, 3);
        assertEquals(res, 2);
    }
}