package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:34
 */
public class CountPrimeSetBits {

    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            int count = Integer.bitCount(i);
            if (isPrime(count)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int count) {
        return count == 2
                || count == 3
                || count == 5
                || count == 7
                || count == 11
                || count == 13
                || count == 17
                || count == 19
                || count == 23
                || count == 29
                || count == 31;
    }
}
