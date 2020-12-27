package local.algorithm.leetcode;

public class LongestSubstringWithRepeatingChar {

    public int longestSubstring(String s, int k) {
        return findRec(s.toCharArray(), 0, s.length() - 1, k);
    }

    public int findRec(char[] chars, int start, int end, int k) {
        if (end < start || end - start + 1 < k) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = start; i <= end; i++) {
            if (count[chars[i] - 'a'] < k) {
                return Math.max(
                        findRec(chars, start, i - 1, k),
                        findRec(chars, i + 1, end, k)
                );
            }
        }
        return end - start + 1;
    }
}
