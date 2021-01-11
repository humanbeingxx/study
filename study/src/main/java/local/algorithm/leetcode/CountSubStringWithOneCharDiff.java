package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountSubStringWithOneCharDiff {

    static class Pair {
        Map<Character, Integer> key;
        int value;

        public Pair(Map<Character, Integer> key) {
            this.key = key;
        }
    }

    public int countSubstrings(String s, String t) {
        Map<String, Pair> subStringWithExclude = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            for (int j = i + 1; j <= t.length(); j++) {
                StringBuilder stringBuilder = new StringBuilder(t.substring(i, j));
                for (int k = 0; k < stringBuilder.length(); k++) {
                    char old = stringBuilder.charAt(k);
                    stringBuilder.setCharAt(k, '-');
                    String replacedSub = stringBuilder.toString();
                    if (!subStringWithExclude.containsKey(replacedSub)) {
                        subStringWithExclude.put(replacedSub, new Pair(new HashMap<>()));
                        subStringWithExclude.get(replacedSub).key.put(old, 1);
                    } else {
                        Map<Character, Integer> oldCount = subStringWithExclude.get(replacedSub).key;
                        oldCount.put(old, oldCount.getOrDefault(old, 0) + 1);
                    }
                    stringBuilder.setCharAt(k, old);
                }
            }
        }
        for (Pair pair : subStringWithExclude.values()) {
            for (Integer count : pair.key.values()) {
                pair.value += count;
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                StringBuilder stringBuilder = new StringBuilder(s.substring(i, j));
                for (int k = 0; k < stringBuilder.length(); k++) {
                    char old = stringBuilder.charAt(k);
                    stringBuilder.setCharAt(k, '-');
                    String replacedSub = stringBuilder.toString();
                    if (subStringWithExclude.containsKey(replacedSub)) {
                        Pair pair = subStringWithExclude.get(replacedSub);
                        count += pair.value - pair.key.getOrDefault(old, 0);
                    }
                    stringBuilder.setCharAt(k, old);
                }
            }
        }
        return count;
    }

    public int countSubstringsBetter(String s, String t) {
        int[][] counts = new int[s.length()][t.length()];
        int[][] suffix = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            counts[i][0] = s.charAt(i) == t.charAt(0) ? 0 : 1;
            suffix[i][0] = s.charAt(i) == t.charAt(0) ? 1 : 0;
        }
        for (int i = 0; i < t.length(); i++) {
            counts[0][i] = t.charAt(i) == s.charAt(0) ? 0 : 1;
            suffix[0][i] = t.charAt(i) == s.charAt(0) ? 1 : 0;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = t.length() - 1; j > 0; j--) {
                suffix[i][j] = s.charAt(i) == t.charAt(j) ? suffix[i - 1][j - 1] + 1 : 0;
                counts[i][j] = s.charAt(i) == t.charAt(j) ? counts[i - 1][j - 1] : suffix[i - 1][j - 1] + 1;
            }
        }

        int sum = 0;
        for (int[] count : counts) {
            for (int val : count) {
                sum += val;
            }
        }
        return sum;
    }
}
