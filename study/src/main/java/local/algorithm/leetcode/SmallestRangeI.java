package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/4 14:53
 */
public class SmallestRangeI {

    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : A) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        if (max - K > min + K) {
            return max - min - 2 * K;
        } else {
            return 0;
        }
    }
}
