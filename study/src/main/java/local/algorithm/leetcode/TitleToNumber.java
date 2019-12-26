package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 0:32
 */
public class TitleToNumber {

    public int titleToNumber(String s) {
        int decimal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            decimal = decimal * 26 + (c - 'A' + 1);
        }
        return decimal;
    }
}
