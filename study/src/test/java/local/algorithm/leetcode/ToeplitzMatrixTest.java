package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class ToeplitzMatrixTest {

    @Test
    public void testIsToeplitzMatrix1() {
        boolean result = new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}});
        assertTrue(result);
    }

    @Test
    public void testIsToeplitzMatrix2() {
        boolean result = new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}});
        assertFalse(result);
    }

    @Test
    public void testIsToeplitzMatrix3() {
        boolean result = new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{1}});
        assertTrue(result);
    }

    @Test
    public void testIsToeplitzMatrix4() {
        boolean result = new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{1, 2, 3}});
        assertTrue(result);
    }

    @Test
    public void testIsToeplitzMatrix5() {
        boolean result = new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{1}, {2}, {3}});
        assertTrue(result);
    }
}