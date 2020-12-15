package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/5 3:42
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            rotate(matrix, i);
        }
    }

    private void rotate(int[][] matrix, int retract) {
        int n = matrix.length;
        int up, right, down, left;
        for (int i = retract; i < n - retract - 1; i++) {
            up = matrix[retract][i];

            right = matrix[i][n - retract - 1];
            matrix[i][n - retract - 1] = up;

            down = matrix[n - retract - 1][n - i - 1];
            matrix[n - retract - 1][n - i - 1] = right;

            left = matrix[n - i - 1][retract];
            matrix[n - i - 1][retract] = down;

            matrix[retract][i]= left;
        }
    }
}
