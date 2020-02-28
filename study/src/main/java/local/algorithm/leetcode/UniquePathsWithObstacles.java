package local.algorithm.leetcode;

public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] counts = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    counts[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        counts[i][j] = 1;
                    } else if (i == 0) {
                        counts[i][j] = counts[i][j - 1];
                    } else if (j == 0) {
                        counts[i][j] = counts[i - 1][j];
                    } else {
                        counts[i][j] = counts[i - 1][j] + counts[i][j - 1];
                    }
                }
            }
        }
        return counts[m-1][n-1];
    }
}
