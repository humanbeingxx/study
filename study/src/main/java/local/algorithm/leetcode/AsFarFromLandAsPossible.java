package local.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {

    public int maxDistance(int[][] grid) {
        int[][] distances = new int[grid.length][grid[0].length];
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[0].length; j++) {
                distances[i][j] = -1;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    addNext(i, j, queue, grid);
                }
            }
        }
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                if (grid[i][j] == 1) {
                    continue;
                }
                if (distances[i][j] == -1) {
                    distances[i][j] = step;
                    addNext(i, j, queue, grid);
                }
            }
            step++;
        }
        int max = -1;
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[0].length; j++) {
                max = Math.max(max, distances[i][j]);
            }
        }
        return max;
    }

    private void addNext(int i, int j, Queue<int[]> queue, int[][] grid) {
        if (i > 0 && grid[i - 1][j] == 0) {
            queue.add(new int[]{i - 1, j});
        }
        if (j > 0 && grid[i][j - 1] == 0) {
            queue.add(new int[]{i, j - 1});
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 0) {
            queue.add(new int[]{i + 1, j});
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
            queue.add(new int[]{i, j + 1});
        }
    }
}
