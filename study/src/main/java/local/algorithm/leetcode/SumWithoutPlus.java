package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 22:07
 */
public class SumWithoutPlus {

    public int getSum(int a, int b) {
        int sum = 0;
        int val = 1;
        int ahead = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & val) == val && (b & val) == val) {
                if (ahead == 1) {
                    sum |= val;
                }
                ahead = 1;
            } else if ((a & val) != val && (b & val) != val) {
                if (ahead == 1) {
                    sum |= val;
                    ahead = 0;
                }
            } else {
                if (ahead == 0) {
                    sum |= val;
                }
            }
            val <<= 1;
        }

        return sum;
    }
}
