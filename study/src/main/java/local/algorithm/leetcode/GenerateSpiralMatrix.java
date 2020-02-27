package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-25
 **/
public class GenerateSpiralMatrix {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int direction = 1;
        int val = 1, max = n * n;
        int up = 0, down = n - 1, left = 0, right = n - 1;

        while (val <= max) {
            if (direction == 1) {
                int row = up;
                for (int i = left; i <= right; i++) {
                    result[row][i] = val++;
                }
                up++;
            } else if (direction == 2) {
                int column = right;
                for (int i = up; i <= down; i++) {
                    result[i][column] = val++;
                }
                right--;
            } else if (direction == 3) {
                int row = down;
                for (int i = right; i >= left; i--) {
                    result[row][i] = val++;
                }
                down--;
            } else if (direction == 4) {
                int column = left;
                for (int i = down; i >= up; i--) {
                    result[i][column] = val++;
                }
                left++;
            } else {
                break;
            }

            if (direction == 4) {
                direction = 1;
            } else {
                direction++;
            }
        }

        return result;
    }
}
