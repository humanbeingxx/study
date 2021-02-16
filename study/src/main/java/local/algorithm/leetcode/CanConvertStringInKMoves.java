package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanConvertStringInKMoves {

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> moveCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            int need = tc < sc ? tc + 26 - sc : tc - sc;
            if (need != 0) {
                moveCounts.put(need, moveCounts.getOrDefault(need, 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : moveCounts.entrySet()) {
            max = Math.max(max, entry.getKey() + (entry.getValue() - 1) *26);
        }
        return max <= k;
    }
}
