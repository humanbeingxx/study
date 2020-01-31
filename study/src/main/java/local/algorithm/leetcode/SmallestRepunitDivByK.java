package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class SmallestRepunitDivByK {

    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int num = 1, len = 1;
        while (num % K != 0) {
            num = num % K * 10 + 1;
            len++;
        }
        return len;
    }
}
