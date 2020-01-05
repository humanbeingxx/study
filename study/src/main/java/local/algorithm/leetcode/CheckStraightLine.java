package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:44
 */
public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0], y1 = coordinates[0][1], x2 = coordinates[1][0], y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0], yi = coordinates[i][1];
            if ((y2 - y1) * (xi - x1) != (x2 - x1) * (yi - y1)) {
                return false;
            }
        }
        return true;
    }
}
