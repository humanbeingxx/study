package local.algorithm.leetcode;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1, currLen = 1, lastChar = s.charAt(0), cost = 0;
        for (int i = 1; i < s.length(); i++) {
            cost = 0;
            char c = s.charAt(i);
            if (c == lastChar) {
                currLen++;
                maxLen = Math.min(Math.max(maxLen, currLen + k), s.length());
            } else {
                int index = i;
                while (index < s.length()) {
                    if (s.charAt(index) == lastChar) {
                        index++;
                        currLen++;
                    } else if (cost < k) {
                        currLen++;
                        cost++;
                        index++;
                    } else {
                        break;
                    }
                }
                maxLen = Math.min(Math.max(maxLen, currLen + k - cost), s.length());
                currLen = 1;
                lastChar = c;
            }
        }
        return maxLen;
    }
}
