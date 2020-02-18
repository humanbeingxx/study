package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class SearchMatrixI {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (matrix[0][0] > target) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m, mid = low + (high - low) / 2;
        while (low < high) {
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }
        if (low == m || matrix[low][0] > target) {
            low--;
        }
        int column = low;
        low = 0;
        high = n;
        mid = low + (high - low) / 2;
        while (low < high) {
            if (matrix[column][mid] == target) {
                return true;
            } else if (matrix[column][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }
        return low < n && matrix[column][low] == target;
    }
}
