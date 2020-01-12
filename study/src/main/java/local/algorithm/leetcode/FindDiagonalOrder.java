package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/12 22:01
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int x = 0, y = 0, index = 0, m = matrix.length, n = matrix[0].length, direction = 1;
        int[] result = new int[m * n];

        while (x < m && y < n) {
            int i = x, j = y;
            if (direction == 1) {
                for (; i >= 0 && j < n; i--, j++) {
                    result[index++] = matrix[i][j];
                }
                i++;
                j--;
                if (j < n - 1) {
                    y = j + 1;
                    x = i;
                } else {
                    x = i + 1;
                    y = j;
                }
                direction = -1;
            } else {
                for (; i < m && j >= 0; i++, j--) {
                    result[index++] = matrix[i][j];
                }
                i--;
                j++;
                if (i < m - 1) {
                    x = i + 1;
                    y = j;
                } else {
                    x = i;
                    y = j + 1;
                }
                direction = 1;
            }
        }
        return result;
    }
}
