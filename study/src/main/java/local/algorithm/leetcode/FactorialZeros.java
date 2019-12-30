package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class FactorialZeros {

    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
