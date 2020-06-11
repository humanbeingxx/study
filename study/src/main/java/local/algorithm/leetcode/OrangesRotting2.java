package local.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/4 13:16
 */
public class OrangesRotting2 {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotted = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotted.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        int times = 0;
        while (!rotted.isEmpty()) {
            if (freshCount == 0) {
                break;
            }
            int size = rotted.size();
            for (int k = 0; k < size; k++) {
                int[] rot = rotted.poll();
                int i = rot[0], j = rot[1];
                //up
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    freshCount--;
                    rotted.add(new int[]{i - 1, j});
                }
                //down
                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    freshCount--;
                    rotted.add(new int[]{i + 1, j});
                }
                //left
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    freshCount--;
                    rotted.add(new int[]{i, j - 1});
                }
                //right
                if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    freshCount--;
                    rotted.add(new int[]{i, j + 1});
                }
            }
            times++;
        }
        return freshCount > 0 ? -1 : times;
    }

}
