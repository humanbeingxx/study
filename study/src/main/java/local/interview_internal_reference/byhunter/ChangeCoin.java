package local.interview_internal_reference.byhunter;

import java.util.ArrayList;
import java.util.List;

public class ChangeCoin {

    public int changeCoin(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][2];
        for (int i = 1; i <= amount; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (coin <= i && dp[i - coin][0] >= 0) {
                    if (dp[i][0] == -1) {
                        dp[i][0] = dp[i - coin][0] + 1;
                        dp[i][1] = j;
                    } else if (dp[i][0] > dp[i - coin][0] + 1) {
                        dp[i][0] = dp[i - coin][0] + 1;
                        dp[i][1] = j;
                    }
                }
            }
        }
        return dp[amount][0];
    }

    public List<Integer> changeCoinWithPath(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][2];
        for (int i = 1; i <= amount; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (coin <= i && dp[i - coin][0] >= 0) {
                    if (dp[i][0] == -1 || dp[i][0] > dp[i - coin][0] + 1) {
                        dp[i][0] = dp[i - coin][0] + 1;
                        dp[i][1] = j;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int index = amount;
        while (index > 0) {
            result.add(coins[dp[index][1]]);
            index -= coins[dp[index][1]];
        }
        return result;
    }
}
