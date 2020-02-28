package local.algorithm.leetcode;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] squares = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    squares[i][j] = 1 + Math.min(squares[i - 1][j - 1], Math.min(squares[i - 1][j], squares[i][j - 1]));
                    if (squares[i][j] > max) {
                        max = squares[i][j];
                    }
                }
            }
        }
        return max * max;
    }
}
