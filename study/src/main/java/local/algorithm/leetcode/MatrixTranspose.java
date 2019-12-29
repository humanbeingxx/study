package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 21:18
 */
public class MatrixTranspose {

    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] transposed = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposed[i][j] = A[j][i];
            }
        }
        return transposed;
    }
}
