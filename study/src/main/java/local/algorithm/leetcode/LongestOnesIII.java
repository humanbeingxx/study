package local.algorithm.leetcode;

public class LongestOnesIII {

    public int longestOnes(int[] A, int K) {
        int maxLen = Integer.MIN_VALUE, currLen = 0, start = 0, zeroCount = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] == 0) {
                if (zeroCount == K) {
                    while (start <= j && A[start] != 0) {
                        start++;
                        currLen--;
                    }
                    start++;
                    maxLen = Math.max(maxLen, currLen);
                } else {
                    zeroCount++;
                    currLen++;
                    maxLen = Math.max(maxLen, currLen);
                }
            } else {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}
