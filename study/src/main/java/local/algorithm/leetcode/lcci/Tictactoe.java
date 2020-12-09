package local.algorithm.leetcode.lcci;

public class Tictactoe {

    public String tictactoe(String[] board) {
        boolean pending = false;
        int n = board.length;
        int sum;
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            sum = 0;
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == 'O') {
                    sum++;
                } else if (c == 'X') {
                    sum--;
                } else {
                    pending = true;
                }
            }
            if (sum == n) {
                return "O";
            } else if (sum == -n) {
                return "X";
            }
        }
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                char c = board[j].charAt(i);
                if (c == 'O') {
                    sum++;
                } else if (c == 'X') {
                    sum--;
                } else {
                    pending = true;
                }
            }
            if (sum == n) {
                return "O";
            } else if (sum == -n) {
                return "X";
            }
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            char c = board[i].charAt(i);
            if (c == 'O') {
                sum++;
            } else if (c == 'X') {
                sum--;
            } else {
                pending = true;
            }
            if (sum == n) {
                return "O";
            } else if (sum == -n) {
                return "X";
            }
        }
        for (int i = 0; i < n; i++) {
            char c = board[n - i - 1].charAt(i);
            if (c == 'O') {
                sum++;
            } else if (c == 'X') {
                sum--;
            } else {
                pending = true;
            }
            if (sum == n) {
                return "O";
            } else if (sum == -n) {
                return "X";
            }
        }
        return pending ? "Pending" : "Draw";
    }
}
