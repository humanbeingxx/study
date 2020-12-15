package local.algorithm.leetcode.lcof;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/13 17:11
 */
public class PresentValue {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] values = new int[m][n];
        values[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            values[i][0] = values[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            values[0][i] = values[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                values[i][j] = grid[i][j] + Math.max(values[i - 1][j], values[i][j - 1]);
            }
        }
        return values[m - 1][n - 1];
    }
}
