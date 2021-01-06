package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class CompressString {

    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }

        int pos = 0, end = 0;
        while (pos < chars.length && end < chars.length) {
            chars[pos] = chars[end];
            int start = end;
            while (end < chars.length && chars[pos] == chars[end]) {
                end++;
            }
            if (end - start > 1) {
                for (char c : String.valueOf(end - start).toCharArray()) {
                    chars[++pos] = c;
                }
            }
            pos++;
        }

        return pos;
    }
}
