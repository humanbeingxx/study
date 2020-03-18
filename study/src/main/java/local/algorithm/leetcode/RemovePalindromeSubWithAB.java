package local.algorithm.leetcode;

public class RemovePalindromeSubWithAB {

    public int removePalindromeSub(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return 2;
            }
        }
        return 1;
    }
}
