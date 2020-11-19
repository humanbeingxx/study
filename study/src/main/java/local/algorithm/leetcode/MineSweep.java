package local.algorithm.leetcode;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class MineSweep {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Set<Pair<Integer, Integer>> checked = new HashSet<>();
        updateBoardRec(board, click, checked);
        return board;
    }

    private boolean updateBoardRec(char[][] board, int[] click, Set<Pair<Integer, Integer>> checked) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return true;
        }
        Pair<Integer, Integer> current = new Pair<>(click[0], click[1]);
        if (!checked.contains(current)) {
            boolean around = checkAround(board, click);
            checked.add(current);
            if (!around) {
                for (int i = Math.max(0, click[0] - 1); i < Math.min(click[0] + 2, board.length); i++) {
                    for (int j = Math.max(0, click[1] - 1); j < Math.min(click[1] + 2, board[0].length); j++) {
                        if (updateBoardRec(board, new int[]{i, j}, checked)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkAround(char[][] board, int[] click) {
        int mineCount = 0;
        for (int i = Math.max(0, click[0] - 1); i < Math.min(click[0] + 2, board.length); i++) {
            for (int j = Math.max(0, click[1] - 1); j < Math.min(click[1] + 2, board[0].length); j++) {
                mineCount += board[i][j] == 'M' ? 1 : 0;
            }
        }
        if (mineCount > 0) {
            board[click[0]][click[1]] = (char) (mineCount + '0');
            return true;
        } else {
            board[click[0]][click[1]] = 'B';
            return false;
        }
    }


    public String display(char[][] result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                stringBuilder.append(result[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
