package local.algorithm.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DicesProbability {

    public double[] dicesProbability(int n) {
        int[][] ways = new int[n * 6 + 1][n + 1];
        for (int i = 1; i <= 6; i++) {
            ways[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j < n * 6 + 1; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) {
                        break;
                    }
                    ways[j][i] += ways[j - k][i - 1];
                }
            }
        }

        double[] result = new double[n * 6 - n + 1];
        for (int i = n; i <= n * 6; i++) {
            int way = ways[i][n];
            BigDecimal p = new BigDecimal(way * Math.pow((1 / (double) 6), n));
            result[i - n] = p.setScale(5, RoundingMode.HALF_UP).doubleValue();
        }
        return result;
    }
}
