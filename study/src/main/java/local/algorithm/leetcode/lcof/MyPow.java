package local.algorithm.leetcode.lcof;

public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / myPow(1 / x, -(n + 1));
            }
            return 1 / myPow(x, -n);
        }
        int exp = 1;
        double result = x;
        while (exp < n / 2) {
            result *= result;
            exp *= 2;
        }
        if (exp == n) {
            return result;
        } else {
            return result * myPow(x, n - exp);
        }
    }
}
