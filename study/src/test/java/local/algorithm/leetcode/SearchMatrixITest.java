package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class SearchMatrixITest {

    @Test
    public void testSearchMatrix1() {
        boolean result = new SearchMatrixI().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3);
        assertTrue(result);
    }

    @Test
    public void testSearchMatrix2() {
        boolean result = new SearchMatrixI().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 11);
        assertTrue(result);
    }

    @Test
    public void testSearchMatrix3() {
        boolean result = new SearchMatrixI().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 30);
        assertTrue(result);
    }

    @Test
    public void testSearchMatrix4() {
        boolean result = new SearchMatrixI().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 51);
        assertFalse(result);
    }
}