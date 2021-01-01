package local.algorithm.leetcode;

public class BalancedString {

    public int balancedString(String s) {
        int[] counts = new int[26];
        int target = s.length() / 4;
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'A']++;
        }
        int start = 0, end = 0, minLen = s.length();
        while (end < s.length()) {
            counts[s.charAt(end) - 'A']--;
            while (start < s.length() && counts['Q' - 'A'] <= target &&
                    counts['W' - 'A'] <= target &&
                    counts['E' - 'A'] <= target &&
                    counts['R' - 'A'] <= target) {
                minLen = Math.min(minLen, end - start + 1);
                counts[s.charAt(start) - 'A']++;
                start++;
            }
            end++;
        }
        return minLen;
    }
}
