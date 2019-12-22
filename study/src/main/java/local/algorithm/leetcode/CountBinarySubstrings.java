package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 17:07
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int count = 0, count0 = 0, count1 = 0;
        char pre = s.charAt(0);
        if (pre == '0') {
            count0 = 1;
        } else {
            count1 = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (pre == '0') {
                    count0++;
                } else {
                    count0 = 1;
                }
                if (count0 <= count1) {
                    count++;
                }
            } else {
                if (pre == '1') {
                    count1++;
                } else {
                    count1 = 1;
                }
                if (count1 <= count0) {
                    count++;
                }
            }
            pre = c;
        }
        return count;
    }
}
