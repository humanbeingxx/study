package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 22:26
 */
public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int lc = 0, rc = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                lc++;
            } else {
                rc++;
            }
            if (lc == rc) {
                count++;
                lc = 0;
                rc = 0;
            }
        }
        return count;
    }
}
