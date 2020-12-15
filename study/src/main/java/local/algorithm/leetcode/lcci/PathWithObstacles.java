package local.algorithm.leetcode.lcci;

import java.util.ArrayList;
import java.util.List;

public class PathWithObstacles {

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> path = new ArrayList<>();
        boolean[][] checked = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        rec(obstacleGrid, 0, 0, path, checked);
        return path;
    }

    private boolean rec(int[][] grid, int i, int j, List<List<Integer>> path, boolean[][] checked) {
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1 || checked[i][j]) {
            return false;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            path.add(point(i, j));
            return true;
        }
        path.add(point(i, j));
        boolean pass = false;
        if (i < grid.length - 1) {
            pass = rec(grid, i + 1, j, path, checked);
        }
        if (!pass && j < grid[0].length - 1) {
            pass = rec(grid, i, j + 1, path, checked);
        }
        if (pass) {
            return true;
        } else {
            path.remove(path.size() - 1);
            checked[i][j] = true;
            return false;
        }
    }

    private List<Integer> point(int i, int j) {
        List<Integer> point = new ArrayList<>(2);
        point.add(i);
        point.add(j);
        return point;
    }
}
