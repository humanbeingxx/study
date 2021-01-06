package local.algorithm.leetcode;

public class IntegerBreak {

    public int integerBreak(int n) {
        int[] counted = new int[n + 1];
        counted[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                counted[i] = Math.max(counted[i], counted[j] * (i - j));
                counted[i] = Math.max(counted[i], j * (i - j));
            }
        }
        return counted[n];
    }
}
