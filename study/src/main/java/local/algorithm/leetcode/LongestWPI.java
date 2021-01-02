package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestWPI {

    public int longestWPI(int[] hours) {
        int delta = 0, longest = 0;
        Map<Integer, Integer> existWP = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int hour = hours[i];
            if (hour > 8) {
                delta++;
            } else {
                delta--;
            }
            if (delta > 0) {
                longest = i + 1;
            } else {
                if (existWP.containsKey(delta - 1)) {
                    longest = Math.max(longest, i - existWP.get(delta-1));
                }
                existWP.putIfAbsent(delta, i);
            }
        }
        return longest;
    }
}
