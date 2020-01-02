package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int low = 0, high = A.length - 1, pos = (high + low) / 2;
        while (low <= high) {
            if ((pos == 0 && A[pos] > A[pos + 1]) || (pos == A.length - 1 && A[pos] > A[pos - 1])) {
                return pos;
            }
            if (A[pos] > A[pos + 1] && A[pos] > A[pos - 1]) {
                return pos;
            } else if (A[pos] > A[pos - 1] && A[pos] < A[pos + 1]) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
            pos = (high + low) / 2;
        }
        return -1;
    }
}
