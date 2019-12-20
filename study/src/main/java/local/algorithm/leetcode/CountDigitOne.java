package local.algorithm.leetcode;

/**
 * 233. 数字 1 的个数
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class CountDigitOne {

    public int countDigitOne(int n) {
        return 0;
    }

    public int force(int from, int to) {
        int sum = 0;
        for (int i = from; i < to; i++) {
            int value = i;
            int count = 0;
            while (value > 0) {
                if (value % 10 == 1) {
                    count++;
                }
                value /= 10;
            }
            sum += count;
        }
        return sum;
    }
}
