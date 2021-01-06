package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class ReverseStrK {

    public String reverseStr(String s, int k) {
        char[] chars = new char[s.length()];
        int start = 0;
        for (; start < s.length(); start += 2 * k) {
            reverse(s.substring(start, Math.min(start + 2 * k, s.length())), chars, start, k);
        }

        return new String(chars);
    }

    void reverse(String str, char[] chars, int start, int k) {
        if (str.length() == 2 * k) {
            copy(str, k - 1, 0, chars, start);
            copy(str, k, 2 * k - 1, chars, start + k);
        } else if (str.length() < k) {
            copy(str, str.length() - 1, 0, chars, start);
        } else if (str.length() >= k && str.length() < 2 * k) {
            copy(str, k - 1, 0, chars, start);
            if (str.length() == k) {
                return;
            }
            copy(str, k, str.length() - 1, chars, start + k);
        }
    }

    void copy(String str, int from, int to, char[] chars, int start) {
        int index = start;
        if (from < to) {
            for (; from <= to; from++) {
                chars[index++] = str.charAt(from);
            }
        } else {
            for (; from >= to; from--) {
                chars[index++] = str.charAt(from);
            }
        }
    }
}
