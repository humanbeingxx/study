package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class RepeatedNTimes {

    public int repeatedNTimes(int[] A) {
        if (A.length <= 2) {
            return Integer.MIN_VALUE;
        }
        if (A[0] == A[A.length - 1]) {
            return A[0];
        }
        for (int i = 1; i < A.length - 1; i++) {
            int i1 = A[i - 1];
            int i2 = A[i];
            int i3 = A[i + 1];
            if (i1 == i2) {
                return i1;
            } else if (i2 == i3) {
                return i2;
            } else if (i1 == i3) {
                return i1;
            }
        }
        return Integer.MIN_VALUE;
    }
}
