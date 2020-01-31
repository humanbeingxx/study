package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class StrWithout3a3b {

    public String strWithout3a3b(int A, int B) {
        char a = 'a', b = 'b';
        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
            temp = a;
            a = b;
            b = (char) temp;
        }
        StringBuilder sb = new StringBuilder();
        while (A > 0 || B > 0) {
            if (A > 0) {
                sb.append(a);
                A--;
            }
            if (A > B) {
                sb.append(a);
                A--;
            }
            if (B > 0) {
                sb.append(b);
                B--;
            }
        }
        return sb.toString();
    }
}
