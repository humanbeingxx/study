package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-20
 **/
public class MyPow {

    public double myPow(double x, int n) {
        boolean neg = n < 0;
        long nl = n;
        nl = Math.abs(nl);
        double result = 1;
        for (; nl > 0; nl /= 2) {
            if (nl % 2 == 1) {
                result *= x;
            }
            x *= x;

        }
        return neg ? 1 / result : result;
    }
}
