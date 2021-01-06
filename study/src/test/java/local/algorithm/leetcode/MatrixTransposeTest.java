package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 21:21
 */
public class MatrixTransposeTest {

    @Test
    public void testTranspose() {
        int[][] result = new MatrixTranspose().transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertTrue(diff(result, new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}));

        result = new MatrixTranspose().transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
        assertTrue(diff(result, new int[][]{{1, 4}, {2, 5}, {3, 6}}));
    }

    private boolean diff(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}