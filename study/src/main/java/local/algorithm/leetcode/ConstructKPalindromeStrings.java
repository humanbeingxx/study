package local.algorithm.leetcode;

public class ConstructKPalindromeStrings {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if ((counts[i] & 1) == 1) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}
