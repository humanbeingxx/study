package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:47
 */
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; i < A.length && K > 0; i++, K--) {
            if (A[i] <= 0) {
                A[i] = -A[i];
            } else {
                if (K % 2 != 0) {
                    if (i == 0 || A[i] <= A[i-1]) {
                        A[i] = -A[i];
                    } else {
                        A[i-1] = -A[i-1];
                    }
                }
                break;
            }
        }
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        return sum;
    }
}
