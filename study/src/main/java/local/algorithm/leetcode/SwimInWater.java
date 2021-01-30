package local.algorithm.leetcode;

import java.util.Arrays;

public class SwimInWater {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int min = Math.max(grid[0][0], grid[n - 1][n - 1]), max = n * (n - 1), mid;
        boolean[][] visited = new boolean[n][n];
        while (min < max) {
            mid = (min + max) / 2;
            clear(visited);
            if (dfs(grid, 0, 0, mid, visited)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private void clear(boolean[][] visited) {
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
    }

    private boolean dfs(int[][] grid, int i, int j, int water, boolean[][] visited) {
        visited[i][j] = true;
        if (grid[i][j] > water) {
            return false;
        }
        if (i == grid.length - 1 && j == grid.length - 1) {
            return true;
        }
        if (i > 0 && !visited[i - 1][j]) {
            if (dfs(grid, i - 1, j, water, visited)) {
                return true;
            }
        }
        if (i < grid.length - 1 && !visited[i + 1][j]) {
            if (dfs(grid, i + 1, j, water, visited)) {
                return true;
            }
        }
        if (j > 0 && !visited[i][j - 1]) {
            if (dfs(grid, i, j - 1, water, visited)) {
                return true;
            }
        }
        if (j < grid.length && !visited[i][j + 1]) {
            if (dfs(grid, i, j + 1, water, visited)) {
                return true;
            }
        }
        return false;
    }
}
