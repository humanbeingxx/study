package local.algorithm.leetcode;

public class MaxEqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0, len = 0, cost = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int diff = Math.abs(s.charAt(i) - t.charAt(i));
            cost += diff;
            len++;
            while (start <= i && cost > maxCost) {
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
                len--;
                start++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
