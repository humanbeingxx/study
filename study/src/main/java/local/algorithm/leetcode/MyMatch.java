package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/4 16:40
 */
public class MyMatch {

    public boolean isMatch(String s, String p) {
        boolean[][] matched = new boolean[s.length() + 1][p.length() + 1];
        matched[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                matched[0][i + 1] = matched[0][i];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);
                if (pc == '*') {
                    matched[i + 1][j + 1] = matched[i + 1][j] || matched[i][j + 1];
                } else if (pc == '?' || pc == sc) {
                    matched[i + 1][j + 1] = matched[i][j];
                }
            }
        }
        return matched[s.length()][p.length()];
    }
}
