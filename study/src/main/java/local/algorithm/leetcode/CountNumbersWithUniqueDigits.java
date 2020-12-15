package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/8 16:42
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = 10, temp = 9;
        for (int i = 1; i < n; i++) {
            temp *= (10 - i);
            result += temp;
        }
        return result;
    }
}
