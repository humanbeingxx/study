package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-23
 **/
public class MatrixSetZeros {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] zeroRows = new int[m];
        int[] zeroColumns = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = 1;
                    zeroColumns[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (zeroRows[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (zeroColumns[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
