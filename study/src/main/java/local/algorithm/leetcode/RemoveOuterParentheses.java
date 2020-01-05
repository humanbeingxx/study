package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int start = 0, count = 1;

        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    if (i - start > 1) {
                        sb.append(S, start + 1, i);
                    }
                    start = i + 1;
                }
            }
        }
        return sb.toString();
    }
}
