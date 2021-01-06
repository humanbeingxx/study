package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        Integer val = null;
        for (int i = 0, j = 0; i < matrix.length && j < matrix[0].length; i++, j++) {
            if (val == null) {
                val = matrix[i][j];
            } else if (val != matrix[i][j]) {
                return false;
            }
        }
        // down
        for (int i = 1; i < matrix.length; i++) {
            val = null;
            for (int j = i, k = 0; j < matrix.length && k < matrix[0].length; j++, k++) {
                int v = matrix[j][k];
                if (val == null) {
                    val = v;
                } else if (val != v) {
                    return false;
                }
            }
        }

        //right
        for (int i = 1; i < matrix[0].length; i++) {
            val = null;
            for (int j = i, k = 0; j < matrix[0].length && k < matrix.length; j++, k++) {
                int v = matrix[k][j];
                if (val == null) {
                    val = v;
                } else if (val != v) {
                    return false;
                }
            }
        }

        return true;
    }
}
