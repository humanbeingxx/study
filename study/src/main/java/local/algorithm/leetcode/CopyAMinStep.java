package local.algorithm.leetcode;

public class CopyAMinStep {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = n;
            for (int j = 1; j < n; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
