package local.algorithm.leetcode;

public class FindLongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            //not contain
            String palindrome = findPalindrome(s, i, true);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            //contain
            palindrome = findPalindrome(s, i, false);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }

    private String findPalindrome(String s, int mid, boolean containMid) {
        int start = 0, end = 0;
        if (containMid) {
            start = mid - 1;
            end = mid + 1;

        } else {
            start = mid - 1;
            end = mid;
        }
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            } else {
                start--;
                end++;
            }
        }
        return s.substring(start + 1, end);
    }
}
