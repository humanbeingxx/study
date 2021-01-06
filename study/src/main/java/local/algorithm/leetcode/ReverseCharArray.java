package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 15:39
 */
public class ReverseCharArray {

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
