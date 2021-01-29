package local.algorithm.leetcode;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] calculated = new int[m][n];
        calcRec(matrix, 0, 0, calculated);
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, calcRec(matrix, i, j, calculated));
            }
        }
        return max;
    }

    private int calcRec(int[][] matrix, int i, int j, int[][] calculated) {
        if (calculated[i][j] > 0) {
            return calculated[i][j];
        }
        calculated[i][j] = 1;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            calculated[i][j] = Math.max(calculated[i][j], calcRec(matrix, i - 1, j, calculated) + 1);
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            calculated[i][j] = Math.max(calculated[i][j], calcRec(matrix, i, j - 1, calculated) + 1);
        }
        if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
            calculated[i][j] = Math.max(calculated[i][j], calcRec(matrix, i + 1, j, calculated) + 1);
        }
        if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
            calculated[i][j] = Math.max(calculated[i][j], calcRec(matrix, i, j + 1, calculated) + 1);
        }
        return calculated[i][j];
    }
}
