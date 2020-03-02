package local.algorithm.leetcode;

public class GameOfLife {

    private static int KEEP_DEAD = 0;
    private static int KEEP_ALIVE = 1;
    private static int CHANGE_TO_DEAD = 2;
    private static int CHANGE_TO_ALIVE = 3;
    private static int[][] offsets = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {1, 0}, {0, 1}, {1, 1}};

    public void gameOfLife(int[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                change(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] >= 2) {
                    board[i][j] -= 2;
                }
            }
        }
    }

    private void change(int[][] board, int x, int y) {
        int aliveCount = 0;
        for (int[] offset : offsets) {
            int posX = x + offset[0];
            int posY = y + offset[1];
            if (posX < 0 || posY < 0 || posX >= board.length || posY >= board[0].length) {
                continue;
            }
            if (board[posX][posY] != KEEP_DEAD && board[posX][posY] != CHANGE_TO_ALIVE) {
                aliveCount++;
            }
        }
        if (board[x][y] == KEEP_DEAD && aliveCount == 3) {
            board[x][y] = CHANGE_TO_ALIVE;
        } else if (board[x][y] == KEEP_ALIVE && (aliveCount < 2 || aliveCount > 3)) {
            board[x][y] = CHANGE_TO_DEAD;
        }
    }
}
