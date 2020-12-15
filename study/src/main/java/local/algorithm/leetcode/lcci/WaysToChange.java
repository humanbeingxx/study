package local.algorithm.leetcode.lcci;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/20 16:47
 */
public class WaysToChange {

    private static int mod = 1000000007;

    public int waysToChange(int n) {
        int count = 0;
        for (int i = 0; i <= n / 25; i++) {
            count = (count + with10(n - i * 25) % mod) % mod;
        }
        return count;
    }

    private int with10(long n) {
        long n5 = n / 5, n10 = n / 10;
        return (int) ((n5 - n10 + 1) * (n10 + 1) % mod);
    }

}
