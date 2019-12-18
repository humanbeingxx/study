package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class MatrixOperateCount {

    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minColumn = n;
        for (int[] op : ops) {
            int row = op[0];
            int column = op[1];
            if (row < minRow) {
                minRow = row;
            }
            if (column < minColumn) {
                minColumn = column;
            }
        }
        return minColumn * minRow;
    }
}
