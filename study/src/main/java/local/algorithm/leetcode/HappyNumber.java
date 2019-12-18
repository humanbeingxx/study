package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/17 22:14
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int step1 = calcNext(n);
        int step2 = calcNext(calcNext(n));
        if (step1 == 1 || step2 == 1) {
            return true;
        }
        while (step1 != step2) {
            step1 = calcNext(step1);
            if (step1 == 1) {
                return true;
            }
            step2 = calcNext(calcNext(step2));
            if (step2 == 1) {
                return true;
            }
        }

        return false;
    }

    int calcNext(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
