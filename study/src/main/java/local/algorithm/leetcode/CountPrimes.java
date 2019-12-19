package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class CountPrimes {

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = n - 2;
        boolean[] noPrimes = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            for (int j = i * i; j < n; j += i) {
                if (noPrimes[j]) {
                    continue;
                }
                noPrimes[j] = true;
                count--;
            }
        }
        return count;
    }
}
