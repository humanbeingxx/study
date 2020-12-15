package local.algorithm.leetcode;

public class MaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE, maxFirst = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            int second = A[j];
            maxFirst = Math.max(maxFirst, A[j - 1] + j - 1);
            max = Math.max(second - j + maxFirst, max);
        }
        return max;
    }
}
