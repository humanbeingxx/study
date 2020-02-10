package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int steps = m + n - 2;
        int[][][] dp = new int[steps + 1][m][n];
        dp[0][0][0] = 1;
        for (int i = 1; i < steps + 1; i++) {
            for (int j = 0; j < Math.min(i + 1, m); j++) {
                for (int k = 0; k < Math.min(i + 1, n); k++) {
                    //left
                    if (j >= 1) {
                        dp[i][j][k] += dp[i - 1][j - 1][k];
                    }
                    //up
                    if (k >= 1) {
                        dp[i][j][k] += dp[i - 1][j][k - 1];
                    }
                }
            }
        }
        return dp[steps][m - 1][n - 1];
    }
}
