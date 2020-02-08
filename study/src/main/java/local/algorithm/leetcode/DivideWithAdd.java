package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-08
 **/
public class DivideWithAdd {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor cannot be 0");
        }
        boolean diffPos = (dividend > 0) ^ (divisor > 0);
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int result = 0;
        while (dividend <= divisor) {
            int tempResult = -1;
            int tempDivisor = divisor;
            while (dividend <= (tempDivisor << 1)) {
                if (tempDivisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                tempResult <<= 1;
                tempDivisor <<= 1;
            }
            result += tempResult;
            dividend -= tempDivisor;
        }

        if (!diffPos) {
            if (result == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }

}
