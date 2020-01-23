package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-20
 **/
public class TheZWord {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        boolean isDown = true;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[row].append(s.charAt(i));
            if (isDown) {
                if (row == numRows - 1) {
                    row--;
                    isDown = false;
                } else {
                    row++;
                }
            } else {
                if (row == 0) {
                    row = 1;
                    isDown = true;
                } else {
                    row--;
                }
            }
        }
        StringBuilder sb = sbs[0];
        for (int i = 1; i < sbs.length; i++) {
            sb.append(sbs[i]);
        }
        return sb.toString();
    }
}
