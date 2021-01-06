package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class MyRegex {

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            if (p.length() == 1 || p.charAt(1) != '*') {
                return false;
            } else {
                return isMatch(s, p.substring(2));
            }
        }
        char matchChar = p.charAt(0);
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        }
        if (p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            for (int i = 0; i < s.length(); i++) {
                if (matchChar != '.' && s.charAt(i) != matchChar) {
                    break;
                } else {
                    boolean match = isMatch(s.substring(i + 1), p.substring(2));
                    if (match) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (matchChar == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return s.charAt(0) == matchChar && isMatch(s.substring(1), p.substring(1));
            }
        }
    }
}
