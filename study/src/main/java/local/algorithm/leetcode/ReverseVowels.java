package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 0:25
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            while (start < end && !isVowels(s.charAt(start))) {
                start++;
            }
            while (end > start && !isVowels(s.charAt(end))) {
                end--;
            }
            if (start >= end) {
                break;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    private boolean isVowels(char c) {
        return c == 'a'
                || c == 'e'
                || c == 'o'
                || c == 'i'
                || c == 'u'
                || c == 'A'
                || c == 'E'
                || c == 'O'
                || c == 'I'
                || c == 'U'
                ;
    }
}
