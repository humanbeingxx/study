package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class Tictactoe {

    public String tictactoe(int[][] moves) {
        int[][] init = new int[3][3];
        for (int i = 0; i < moves.length; i += 2) {
            init[moves[i][0]][moves[i][1]] = 1;
        }
        if (check(init)) {
            return "A";
        }
        init = new int[3][3];

        for (int i = 1; i < moves.length; i += 2) {
            init[moves[i][0]][moves[i][1]] = 1;
        }
        if (check(init)) {
            return "B";
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }

    private boolean check(int[][] status) {
        return (status[0][0] == 1 && status[0][1] == 1 && status[0][2] == 1)
                || (status[1][0] == 1 && status[1][1] == 1 && status[1][2] == 1)
                || (status[2][0] == 1 && status[2][1] == 1 && status[2][2] == 1)
                || (status[0][0] == 1 && status[1][0] == 1 && status[2][0] == 1)
                || (status[0][1] == 1 && status[1][1] == 1 && status[2][1] == 1)
                || (status[0][2] == 1 && status[1][2] == 1 && status[2][2] == 1)
                || (status[0][0] == 1 && status[1][1] == 1 && status[2][2] == 1)
                || (status[2][0] == 1 && status[1][1] == 1 && status[0][2] == 1);
    }
}
