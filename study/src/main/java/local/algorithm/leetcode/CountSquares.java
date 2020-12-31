package local.algorithm.leetcode;

public class CountSquares {

    public int countSquares(int[][] matrix) {
        int[][] maxLengths = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            maxLengths[i][0] = matrix[i][0];
        }
        for (int i = 0; i < matrix[0].length; i++) {
            maxLengths[0][i] = matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    maxLengths[i][j] = 0;
                } else {
                    maxLengths[i][j] = Math.min(Math.min(maxLengths[i][j - 1], maxLengths[i - 1][j]),
                            maxLengths[i - 1][j - 1]) + 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count += maxLengths[i][j];
            }
        }
        return count;
    }

}
