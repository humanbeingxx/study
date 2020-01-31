package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class StrWithout3a3b {

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while (A > 0 && B > 0) {
            if (A >= B) {
                sb.append('a');
                A--;
            } else {
                sb.append('b');
                B--;
            }
        }
        while (A > 0) {
            sb.append('a');
            A--;
        }
        while (B > 0) {
            sb.append('b');
            B--;
        }
        return sb.toString();
    }
}
