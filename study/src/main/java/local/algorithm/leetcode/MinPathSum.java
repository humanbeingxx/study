package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = grid[i][j];
                } else {
                    if (i == 0) {
                        sum[i][j] = grid[i][j] + sum[i][j - 1];
                    } else if (j == 0) {
                        sum[i][j] = grid[i][j] + sum[i - 1][j];
                    } else {
                        sum[i][j] = grid[i][j] + Math.min(sum[i][j - 1], sum[i - 1][j]);
                    }
                }
            }
        }
        return sum[m - 1][n - 1];
    }
}
