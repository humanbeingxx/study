package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class SearchWord {

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        int rows = board.length, columns = board[0].length;
        boolean[][] used = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (search(board, used, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] used, int row, int column, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        if ((!used[row][column] && index == word.length() - 1 && board[row][column] == c)) {
            return true;
        }
        if (used[row][column] || board[row][column] != c) {
            return false;
        }
        used[row][column] = true;
        //up
        if (row - 1 >= 0) {
            if (search(board, used, row - 1, column, word, index + 1)) {
                return true;
            }
        }
        //down
        if (row + 1 < board.length) {
            if (search(board, used, row + 1, column, word, index + 1)) {
                return true;
            }
        }
        //left
        if (column - 1 >= 0) {
            if (search(board, used, row, column - 1, word, index + 1)) {
                return true;
            }
        }
        //right
        if (column + 1 < board[0].length) {
            if (search(board, used, row, column + 1, word, index + 1)) {
                return true;
            }
        }

        used[row][column] = false;
        return false;
    }
}
