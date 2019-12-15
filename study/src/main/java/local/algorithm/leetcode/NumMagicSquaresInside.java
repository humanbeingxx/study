package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 21:17
 */
public class NumMagicSquaresInside {

    static int sum33 = 15;

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int rowEnd = rows - 3;
        int columnEnd = columns - 3;
        int count = 0;
        for (int i = 0; i <= rowEnd; i++) {
            for (int j = 0; j <= columnEnd; j++) {
                if (!checkIsMagic(grid, i, j)) {
                    continue;
                }
                if (check(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean check(int[][] grid, int posRow, int posColumn) {
        for (int i = posRow; i < posRow + 3; i++) {
            if (grid[posRow][posColumn] + grid[posRow][posColumn + 1] + grid[posRow][posColumn + 2] != sum33) {
                return false;
            }
        }
        for (int i = posColumn; i < posColumn + 3; i++) {
            if (grid[posRow][posColumn] + grid[posRow + 1][posColumn] + grid[posRow + 2][posColumn] != sum33) {
                return false;
            }
        }
        if (grid[posRow][posColumn] + grid[posRow + 1][posColumn + 1] + grid[posRow + 2][posColumn + 2] != sum33) {
            return false;
        }
        if (grid[posRow + 2][posColumn] + grid[posRow + 1][posColumn + 1] + grid[posRow][posColumn + 2] != sum33) {
            return false;
        }
        return true;
    }

    boolean checkIsMagic(int[][] grid, int posRow, int posColumn) {
        int[] counts = new int[9];
        for (int i = posRow; i < posRow + 3; i++) {
            for (int j = posColumn; j < posColumn + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false;
                }
                counts[grid[i][j] - 1]++;
            }
        }
        for (int count : counts) {
            if (count != 1) {
                return false;
            }
        }
        return true;
    }
}
