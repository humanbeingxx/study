package local.algorithm.leetcode.lcof;

public class CuttingRope {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * dp[j], (i - j) * j));
            }
        }
        return dp[n];
    }
}
