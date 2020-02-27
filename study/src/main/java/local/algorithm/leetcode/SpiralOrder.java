package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-25
 **/
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);
        int direction = 1;
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (true) {
            if (direction == 1 && left <= right) {
                int row = up;
                for (int i = left; i <= right; i++) {
                    result.add(matrix[row][i]);
                }
                up++;
            } else if (direction == 2 && up <= down) {
                int column = right;
                for (int i = up; i <= down; i++) {
                    result.add(matrix[i][column]);
                }
                right--;
            } else if (direction == 3 && left <= right) {
                int row = down;
                for (int i = right; i >= left; i--) {
                    result.add(matrix[row][i]);
                }
                down--;
            } else if (direction == 4 && up <= down) {
                int column = left;
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][column]);
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
