package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-16
 **/
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = matrix.length - 1, y = 0;
        return searchRec(matrix, x, y, target);
    }

    private boolean searchRec(int[][] matrix, int x, int y, int target) {
        if (x < 0 || y > matrix[0].length) {
            return false;
        }
        int leftDown = matrix[x][y];
        if (leftDown == target) {
            return true;
        }
        if (leftDown > target) {
            return searchRec(matrix, x - 1, y, target);
        } else {
            return searchRec(matrix, x, y + 1, target);
        }
    }
}
