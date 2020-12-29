package local.algorithm.leetcode;

public class HasValidPath {

    private boolean[][][] validation = new boolean[7][7][5];

    public HasValidPath() {
        validation[1][4][2] = true;
        validation[1][6][2] = true;
        validation[1][3][4] = true;
        validation[1][5][4] = true;
        validation[1][1][2] = true;
        validation[1][1][4] = true;

        validation[2][3][1] = true;
        validation[2][4][1] = true;
        validation[2][5][3] = true;
        validation[2][6][3] = true;
        validation[2][2][1] = true;
        validation[2][2][3] = true;

        validation[3][1][2] = true;
        validation[3][4][2] = true;
        validation[3][6][2] = true;
        validation[3][2][3] = true;
        validation[3][5][3] = true;
        validation[3][6][3] = true;

        validation[4][2][3] = true;
        validation[4][5][3] = true;
        validation[4][6][3] = true;
        validation[4][1][4] = true;
        validation[4][3][4] = true;
        validation[4][5][4] = true;

        validation[5][2][1] = true;
        validation[5][3][1] = true;
        validation[5][4][1] = true;
        validation[5][1][2] = true;
        validation[5][4][2] = true;
        validation[5][6][2] = true;

        validation[6][2][1] = true;
        validation[6][3][1] = true;
        validation[6][4][1] = true;
        validation[6][1][4] = true;
        validation[6][3][4] = true;
        validation[6][5][4] = true;

    }

    public boolean hasValidPath(int[][] grid) {
        boolean[][] passed = new boolean[grid.length][grid[0].length];
        return tryPathRec(grid, 0, 0, passed);
    }

    private boolean tryPathRec(int[][] grid, int i, int j, boolean[][] passed) {
        if (passed[i][j]) {
            return false;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        passed[i][j] = true;
        int street = grid[i][j];
        if (i > 0 && validNext(street, grid[i - 1][j], 1) && tryPathRec(grid, i - 1, j, passed)) {
            return true;
        }
        if (j > 0 && validNext(street, grid[i][j - 1], 2) && tryPathRec(grid, i, j - 1, passed)) {
            return true;
        }
        if (i < grid.length - 1 && validNext(street, grid[i + 1][j], 3) && tryPathRec(grid, i + 1, j, passed)) {
            return true;
        }
        if (j < grid[0].length - 1 && validNext(street, grid[i][j + 1], 4) && tryPathRec(grid, i, j + 1, passed)) {
            return true;
        }
        return false;
    }

    private boolean validNext(int street, int nextStreet, int direction) {
        return validation[street][nextStreet][direction];
    }
}
