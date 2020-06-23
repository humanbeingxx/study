package local.algorithm.leetcode.lcci;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/22 22:41
 */
public class Multiply {

    public int multiply(int A, int B) {
        if (A == 0 || B == 0 ){
            return 0;
        }
        if (A > 0 && B < 0) {
            if (A > -B) {
                return -mul(A, -B);
            } else {
                return -mul(-B, A);
            }
        }
        if (A < 0 && B > 0) {
            if (-A > B) {
                return -mul(-A, B);
            } else {
                return -mul(B, -A);
            }
        }
        if (A > B) {
            return mul(A, B);
        } else {
            return mul(B, A);
        }
    }

    private int mul(int a, int b) {
        if (b == 0){
            return a;
        }
        return a + multiply(a, b- 1);
    }
}
