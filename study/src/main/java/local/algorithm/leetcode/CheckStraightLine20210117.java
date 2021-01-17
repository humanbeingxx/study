package local.algorithm.leetcode;

public class CheckStraightLine20210117 {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        if (coordinates[1][0] == coordinates[0][0]) {
            for (int[] coordinate : coordinates) {
                if (coordinate[0] != coordinates[0][0]) {
                    return false;
                }
            }
            return true;
        }
        double a = ((double)(coordinates[1][1]-coordinates[0][1])) / (coordinates[1][0]-coordinates[0][0]);
        double b = coordinates[0][1] - a * coordinates[0][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (!check(a,b, coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean check(double a, double b, int[] coordinate) {
        return coordinate[1] == a * coordinate[0] + b;
    }
}
