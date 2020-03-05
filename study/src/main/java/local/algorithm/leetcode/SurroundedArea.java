package local.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedArea {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //up, down
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{0, i});
            queue.add(new int[]{m - 1, i});
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                if (board[pos[0]][pos[1]] == 'O') {
                    board[pos[0]][pos[1]] = '+';
                    addAround(queue, pos, m, n);
                }
            }
        }
        //left, right
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0});
            queue.add(new int[]{i, n - 1});
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                if (board[pos[0]][pos[1]] == 'O') {
                    board[pos[0]][pos[1]] = '+';
                    addAround(queue, pos, m, n);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void addAround(Queue<int[]> queue, int[] pos, int m, int n) {
        if (pos[0] > 0) {
            queue.add(new int[]{pos[0] - 1, pos[1]});
        }
        if (pos[0] < m - 1) {
            queue.add(new int[]{pos[0] + 1, pos[1]});
        }
        if (pos[1] > 0) {
            queue.add(new int[]{pos[0], pos[1] - 1});
        }
        if (pos[1] < n - 1) {
            queue.add(new int[]{pos[0], pos[1] + 1});
        }
    }
}
