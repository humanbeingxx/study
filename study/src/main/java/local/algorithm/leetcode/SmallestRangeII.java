package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class SmallestRangeII {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        K = Math.abs(K);
        int minRange = A[A.length - 1] - A[0];
        for (int i = 1; i < A.length; i++) {
            int min = Math.min(A[0] + K, A[i] - K);
            int max = Math.max(A[A.length - 1] - K, A[i - 1] + K);
            minRange = Math.min(minRange, max - min);
        }
        return minRange;
    }
}
