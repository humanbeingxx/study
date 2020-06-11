package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/6 16:03
 */
public class StrToInt {

    public int strToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        boolean pos = true;
        char firstC = str.charAt(0);
        if (firstC == '-') {
            pos = false;
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                continue;
            } else if (!Character.isDigit(c)) {
                return pos ? result : -result;
            } else if (!checkOverflow(result, c - '0', pos)) {
                return pos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                result = result * 10 + (c - '0');
            }
        }
        return pos ? result : -result;
    }

    private boolean checkOverflow(int val, int nextVal, boolean pos) {
        if (pos) {
            return val < 214748364 || (val == 214748364 && nextVal <= 7);
        } else {
            return val < 214748364 || (val == 214748364 && nextVal <= 8);
        }
    }
}
