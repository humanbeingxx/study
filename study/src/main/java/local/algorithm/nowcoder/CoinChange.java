package local.algorithm.nowcoder;

import java.util.Arrays;

public class CoinChange {

    public int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i < amount; i++) {
                if (i >= coin && dp[i - coin] >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount];
    }
}
