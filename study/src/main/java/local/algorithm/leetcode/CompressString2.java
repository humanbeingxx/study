package local.algorithm.leetcode;

public class CompressString2 {

    public int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }
        int start, end = 0, pos = 0;
        while (end < chars.length) {
            chars[pos] = chars[end];
            start = end++;
            while (end < chars.length && chars[start] == chars[end]) {
                end++;
            }
            if (end - start > 1) {
                String count = String.valueOf(end - start);
                for (int i = 0; i < count.length(); i++) {
                    chars[++pos] = count.charAt(i);
                }
            }
            pos++;
        }
        return pos;
    }
}
