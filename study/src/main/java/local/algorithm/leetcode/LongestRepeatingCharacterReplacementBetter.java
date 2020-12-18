package local.algorithm.leetcode;

public class LongestRepeatingCharacterReplacementBetter {

    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, right = 0, maxCount = 0, maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            counts[c - 'A']++;
            maxCount = Math.max(maxCount, counts[c - 'A']);
            if (right - left + 1 - maxCount > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
