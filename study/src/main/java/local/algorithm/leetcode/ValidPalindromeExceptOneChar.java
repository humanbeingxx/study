package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class ValidPalindromeExceptOneChar {

    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return checkPalindrome(s.substring(start + 1, end + 1))
                        || checkPalindrome(s.substring(start, end));
            }
            start++;
            end--;
        }
        return true;
    }

    boolean checkPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
