package local.algorithm.leetcode;

public class CanMeasureWater {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        int gcd = gcd(Math.min(x, y), Math.max(x, y));
        return z >= gcd ? z % gcd == 0 : gcd % z == 0;
    }

    //x <= y
    private int gcd(int x, int y) {
        if (y % x == 0) {
            return x;
        } else {
            return gcd(y % x, x);
        }
    }
}
