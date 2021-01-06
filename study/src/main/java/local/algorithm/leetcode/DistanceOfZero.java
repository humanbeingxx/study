package local.algorithm.leetcode;

import java.util.Arrays;

public class DistanceOfZero {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] distances = new int[m][n];
        for (int[] distance : distances) {
            Arrays.fill(distance, 99999);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    distances[i][j] = 0;
                } else {
                    if (i > 0) {
                        //up
                        distances[i][j] = Math.min(distances[i][j], distances[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        //left
                        distances[i][j] = Math.min(distances[i][j], distances[i][j - 1] + 1);
                    }
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    //down
                    distances[i][j] = Math.min(distances[i][j], distances[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    //left
                    distances[i][j] = Math.min(distances[i][j], distances[i][j + 1] + 1);
                }
            }
        }
        return distances;
    }
}
