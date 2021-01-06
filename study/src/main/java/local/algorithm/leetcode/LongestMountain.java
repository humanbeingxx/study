package local.algorithm.leetcode;

public class LongestMountain {

    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int maxLen = 0, currLen = 0;
        boolean growing = false, hasTop = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                growing = true;
                if (hasTop) {
                    currLen++;
                    maxLen = Math.max(maxLen, currLen);
                    currLen = 1;
                    hasTop = false;
                } else {
                    currLen++;
                }
            } else if (A[i] > A[i + 1]) {
                if (growing) {
                    hasTop = true;
                    growing = false;
                }
                if (hasTop) {
                    currLen++;
                }
            } else {
                if (hasTop) {
                    currLen++;
                    maxLen = Math.max(currLen, maxLen);
                }
                currLen = 0;
                hasTop = false;
                growing = false;
            }
        }
        if (A[A.length - 1] < A[A.length - 2]) {
            if (hasTop) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}
