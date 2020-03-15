package local.algorithm.leetcode;

public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int result = 0, preCount = 0, diff = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == diff) {
                preCount++;
                result += preCount;
            } else {
                preCount = 0;
                diff = A[i] -A[i-1];
            }
        }
        return result;
    }
}
