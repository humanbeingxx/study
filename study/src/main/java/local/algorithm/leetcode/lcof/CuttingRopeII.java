package local.algorithm.leetcode.lcof;

import java.math.BigDecimal;

public class CuttingRopeII {

    public int cuttingRope(int n) {
        BigDecimal[] dp = new BigDecimal[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new BigDecimal(0);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                BigDecimal cutTwo = new BigDecimal((i - j) * j);
                BigDecimal cutMore = dp[j].multiply(new BigDecimal(i - j));
                if (dp[i].compareTo(cutTwo) < 0) {
                    dp[i] = cutTwo;
                }
                if (dp[i].compareTo(cutMore) < 0) {
                    dp[i] = cutMore;
                }
            }
        }
        return dp[n].remainder(new BigDecimal(1000000007)).intValue();
    }
}
