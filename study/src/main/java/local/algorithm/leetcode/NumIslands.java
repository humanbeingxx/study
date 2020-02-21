package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-21
 **/
public class NumIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    spread(grid, i, j);
                }
            }
        }
        return count;
    }

    private void spread(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        spread(grid, i - 1, j);
        spread(grid, i + 1, j);
        spread(grid, i, j - 1);
        spread(grid, i, j + 1);
    }
}
