package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MincostTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = 0, minDay = 366;
        Set<Integer> needDays = new HashSet<>();
        for (int day : days) {
            needDays.add(day);
            maxDay = Math.max(day, maxDay);
            minDay = Math.min(day, minDay);
        }
        int[] dp = new int[maxDay + 1];
        for (int i = maxDay; i >= minDay; i--) {
            if (!needDays.contains(i)) {
                dp[i] = dp[i + 1];
                continue;
            }

            int cost1 = (i + 1 > maxDay) ? costs[0] : costs[0] + dp[i+1];
            int cost7 = (i + 7 > maxDay) ? costs[1] : costs[1] + dp[i + 7];
            int cost30 = (i + 30 > maxDay) ? costs[2] : costs[2] + dp[i + 30];

            dp[i] = Math.min(Math.min(cost1, cost7), cost30);
        }
        return dp[minDay];
    }
}
