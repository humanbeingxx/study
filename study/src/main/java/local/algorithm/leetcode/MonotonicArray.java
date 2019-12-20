package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) {
            return true;
        }
        int direction = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                continue;
            }
            if (A[i] > A[i - 1]) {
                if (direction == 0) {
                    direction = 1;
                } else if (direction == 2) {
                    return false;
                }
            } else {
                if (direction == 0) {
                    direction = 2;
                } else if (direction == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
