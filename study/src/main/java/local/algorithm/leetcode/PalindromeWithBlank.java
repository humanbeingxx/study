package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 14:06
 */
public class PalindromeWithBlank {

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (!isValid(s.charAt(start)) && start < end) {
                start++;
            }
            if (start >= end) {
                break;
            }
            while (!isValid(s.charAt(end)) && end > start) {
                end--;
            }
            if (end <= start) {
                break;
            }
            if (!equal(s.charAt(start++), s.charAt(end--))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean equal(char c1, char c2) {
        if (c1 >= 'a') {
            c1 -= ('a' - 'A');
        }

        if (c2 >= 'a') {
            c2 -= ('a' - 'A');
        }
        return c1 == c2;
    }
}
