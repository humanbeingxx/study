package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStrChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> lengthWithEnd = new HashMap<>();
        lengthWithEnd.put(words[0], 1);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            int maxLen = lengthWithEnd.getOrDefault(word.substring(1), 0) + 1;
            for (int j = 1; j < word.length() - 1; j++) {
                String pre = word.substring(0, j) + word.substring(j + 1);
                maxLen = Math.max(maxLen, lengthWithEnd.getOrDefault(pre, 0) + 1);
            }
            maxLen = Math.max(maxLen, lengthWithEnd.getOrDefault(word.substring(0, word.length() - 1), 0) + 1);
            lengthWithEnd.put(word, maxLen);
        }
        int max = 0;
        for (Integer len : lengthWithEnd.values()) {
            max = Math.max(max, len);
        }
        return max;
    }
}
