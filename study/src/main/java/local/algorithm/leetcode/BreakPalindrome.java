package local.algorithm.leetcode;

public class BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        int end = chars.length / 2;
        for (int i = 0; i < end; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[chars.length - 1] += 1;
        return new String(chars);
    }
}
