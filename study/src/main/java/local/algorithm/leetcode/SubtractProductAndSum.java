package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            int remain = n % 10;
            sum += remain;
            product *= remain;
            n /= 10;
        }
        return product - sum;
    }
}
