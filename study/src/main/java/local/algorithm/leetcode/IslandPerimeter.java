package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];
                if (curr != 1) {
                    continue;
                }
                //up
                if (i == 0 || grid[i - 1][j] == 0) {
                    perimeter++;
                }

                //down
                if (i == m - 1 || grid[i + 1][j] == 0) {
                    perimeter++;
                }

                //left
                if (j == 0 || grid[i][j - 1] == 0) {
                    perimeter++;
                }

                //right
                if (j == n - 1 || grid[i][j + 1] == 0) {
                    perimeter++;
                }
            }
        }
        return perimeter;
    }
}
