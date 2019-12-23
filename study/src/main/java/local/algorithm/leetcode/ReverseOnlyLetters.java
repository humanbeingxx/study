package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        int i = 0, j = S.length() - 1;
        char[] chars = S.toCharArray();
        while (i < j && i < chars.length && j < chars.length) {
            while (i < chars.length && !isLetter(chars[i])) {
                i++;
            }
            while (j >= 0 && !isLetter(chars[j])) {
                j--;
            }
            if (i >= j || i == chars.length) {
                break;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    private boolean isLetter(Character c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
