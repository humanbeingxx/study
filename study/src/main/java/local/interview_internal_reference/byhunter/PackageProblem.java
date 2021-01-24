package local.interview_internal_reference.byhunter;

import java.util.ArrayList;
import java.util.List;

public class PackageProblem {

    public int putMost01(int totalWeight, int[] weights, int[] values) {
        int[] dp = new int[totalWeight + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = totalWeight; j >= 1; j--) {
                if (weights[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }


    public List<Integer> putMostAll(int totalWeight, int[] weights, int[] values) {
        int[][] dp = new int[totalWeight + 1][2];
        for (int i = 1; i <= totalWeight; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            for (int j = 0; j < weights.length; j++) {
                int weight = weights[j];
                int value = values[j];
                if (weight <= i && dp[i - weight][0] >= 0) {
                    if (dp[i - weight][0] + value > dp[i][0] || dp[i][0] == -1) {
                        dp[i][0] = dp[i - weight][0] + value;
                        dp[i][1] = j;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = totalWeight; i >= 0; i -= weights[dp[i][1]]) {
            result.add(weights[dp[i][1]]);
        }
        return result;
    }

    public int putMostMulti(int totalWeight, int[] weights, int[] values, int[] amounts) {
        //convert to 01 problem
        int[] dp = new int[totalWeight + 1];
        int numOfItem = 1;
        for (int item = 0; item < amounts.length; item++) {
            int amount = amounts[item];
            for (int i = 0; i < amount; i++, numOfItem++) {
                for (int j = totalWeight; j >= 1; j--) {
                    if (weights[item] <= j) {
                        dp[j] = Math.max(dp[j], dp[j - weights[item]] + values[item]);
                    }
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}
