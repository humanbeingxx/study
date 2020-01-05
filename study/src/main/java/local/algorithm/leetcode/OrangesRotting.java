package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/4 13:16
 */
public class OrangesRotting {

    public int orangesRotting(int[][] grid) {
        List<int[]> rots = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    rots.add(new int[]{i, j});
                }
            }
        }

        boolean changed;
        int times = 0;
        do {
            changed = false;
            List<int[]> nextRots = new ArrayList<>();
            for (int[] rot : rots) {
                int i = rot[0], j = rot[1];
                //up
                if (i > 0) {
                    if (grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                        changed = true;
                        nextRots.add(new int[]{i - 1, j});
                    }
                }
                //down
                if (i < n - 1) {
                    if (grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                        changed = true;
                        nextRots.add(new int[]{i + 1, j});
                    }
                }
                //left
                if (j > 0) {
                    if (grid[i][j - 1] == 1) {
                        grid[i][j - 1] = 2;
                        changed = true;
                        nextRots.add(new int[]{i, j - 1});
                    }
                }
                //right
                if (j < m - 1) {
                    if (grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2;
                        changed = true;
                        nextRots.add(new int[]{i, j + 1});
                    }
                }
            }
            rots = nextRots;
            if (changed) {
                times++;
            }
        } while (changed);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return times;
    }

}
