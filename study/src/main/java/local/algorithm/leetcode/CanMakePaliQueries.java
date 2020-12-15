package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CanMakePaliQueries {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(check(s, query));
        }
        return result;
    }

    private boolean check(String s, int[] query) {
        int start = query[0], end = query[1], times = query[2];
        boolean[] appears = new boolean[26];
        for (int i = start; i <= end; i++) {
            int pos = s.charAt(i) - 'a';
            appears[pos] = !appears[pos];
        }
        int need = 0;
        for (boolean appear : appears) {
            if (appear) {
                need++;
            }
        }
        need /= 2;
        return times >= need;
    }

    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        int[][] alphaCount = new int[s.length()][26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphaCount[i][c - 'a'] = 1;
            if (i > 0) {
                for (int j = 0; j < alphaCount[i - 1].length; j++) {
                    alphaCount[i][j] += alphaCount[i - 1][j];
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], times = query[2];
            int need = 0;
            for (int i = 0; i < 26; i++) {
                if (left > 0) {
                    need += (alphaCount[right][i] - alphaCount[left - 1][i]) & 1;
                } else {
                    need += alphaCount[right][i] & 1;
                }
            }
            result.add(need / 2 <= times);
        }
        return result;
    }

    public List<Boolean> canMakePaliQueries3(String s, int[][] queries) {
        int[] alphaCount = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            alphaCount[i] = 1 << pos;
            if (i > 0) {
                alphaCount[i] ^= alphaCount[i - 1];
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], times = query[2];
            int need = left > 0 ? alphaCount[right] ^ alphaCount[left - 1] : alphaCount[right];
            result.add(Integer.bitCount(need) / 2 <= times);
        }
        return result;
    }
}
