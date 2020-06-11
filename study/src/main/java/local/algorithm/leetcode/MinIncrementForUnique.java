package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/27 16:34
 */
public class MinIncrementForUnique {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int inc = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                inc += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return inc;
    }
}
