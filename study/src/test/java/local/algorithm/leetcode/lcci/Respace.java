package local.algorithm.leetcode.lcci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Respace {

    public int respace(String[] dictionary, String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }
        int[] dp = new int[sentence.length()];
        Set<String> dictSet = new HashSet<>(Arrays.asList(dictionary));
        if (dictSet.contains(sentence.substring(0, 1))) {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i < sentence.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                String subStr = sentence.substring(j, i + 1);
                if (j == 0) {
                    if (dictSet.contains(subStr)) {
                        min = 0;
                        break;
                    } else {
                        min = Math.min(min, i + 1);
                    }
                } else {
                    if (dictSet.contains(subStr)) {
                        min = Math.min(min, dp[j - 1]);
                    } else {
                        min = Math.min(min, dp[j - 1] + i - j + 1);
                    }
                }
            }
            dp[i] = min;
        }
        return dp[sentence.length() - 1];
    }
}
