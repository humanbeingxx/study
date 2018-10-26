package local.before.d1026;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/26 下午9:50
 **/
public class NeighbourMatrixTest {

    @Test
    public void testFindNeighbour() {
        int[][] matrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 1, 0}};
        int[][] result = NeighbourMatrix.findNeighbour(matrix);

        int[][] expected = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        assertEqualMatrix(result, expected);
    }

    @Test
    public void testFindNeighbour2() {
        int[][] matrix = {{0, 0, 1, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 1, 0}};
        int[][] result = NeighbourMatrix.findNeighbour(matrix);

        int[][] expected = {{0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        assertEqualMatrix(result, expected);
    }

    @Test
    public void testFindNeighbour3() {
        int[][] matrix = {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 1, 0}};
        int[][] result = NeighbourMatrix.findNeighbour(matrix);

        int[][] expected = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        assertEqualMatrix(result, expected);
    }

    private void assertEqualMatrix(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                Assert.assertEquals(a[i][j], b[i][j], "posA " + i + " posB " + j);
            }
        }
    }
}