package local.algorithm.leetcode;

public class MaxIncreaseKeepingSkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] columnMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                columnMax[i] = Math.max(columnMax[i], grid[j][i]);
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                result += Math.min(rowMax[i], columnMax[j]) - grid[i][j];
            }
        }
        return result;
    }
}
