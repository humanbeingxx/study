package local.algorithm.leetcode;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int area = countArea(grid, i, j);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    private int countArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        //up
        count += countArea(grid, i - 1, j);
        //down
        count += countArea(grid, i + 1, j);
        //left
        count += countArea(grid, i, j - 1);
        //right
        count += countArea(grid, i, j + 1);
        return count;
    }
}
