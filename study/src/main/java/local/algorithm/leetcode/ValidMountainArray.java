package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int top = 0;
        if (A[0] < A[1]) {
            top = 1;
        } else {
            return false;
        }
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                return false;
            }

            if (top == 2 && A[i] > A[i - 1]) {
                return false;
            }

            if (top == 1 && A[i] < A[i - 1]) {
                top = 2;
            }


        }

        return top == 2;
    }
}
