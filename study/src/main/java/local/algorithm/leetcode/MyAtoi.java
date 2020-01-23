package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-21
 **/
public class MyAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0, result = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) == ' ') {
                continue;
            } else if (!valid(str.charAt(index))) {
                return 0;
            } else {
                break;
            }
        }
        if (index == str.length()) {
            return 0;
        }
        int pn = 1;
        if (str.charAt(index) == '-') {
            pn = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        } else {
            char c = str.charAt(index);
            if (!validDigit(c)) {
                return 0;
            }
            result = pn == -1 ? '0' - c : c - '0';
            index++;
        }
        for (; index < str.length(); index++) {
            char c = str.charAt(index);
            if (!validDigit(c)) {
                break;
            } else {
                int d = c - '0';
                if (pn == 1) {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && d > 7)) {
                        return Integer.MAX_VALUE;
                    }
                    result = result * 10 + d;
                } else {
                    if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && d > 8)) {
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 - d;
                }
            }
        }
        return result;
    }

    private boolean valid(char c) {
        return c == '+' || c == '-' || validDigit(c);
    }

    private boolean validDigit(char c) {
        return (c >= '0' && c <= '9');
    }
}
