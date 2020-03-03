package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> saw = new HashSet<>(9);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (saw.contains(c)) {
                    return false;
                } else {
                    saw.add(c);
                }
            }
            saw.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }
                if (saw.contains(c)) {
                    return false;
                } else {
                    saw.add(c);
                }
            }
            saw.clear();
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        char c = board[k][l];
                        if (c == '.') {
                            continue;
                        }
                        if (saw.contains(c)) {
                            return false;
                        } else {
                            saw.add(c);
                        }
                    }
                }
                saw.clear();
            }
        }

        return true;
    }
}
