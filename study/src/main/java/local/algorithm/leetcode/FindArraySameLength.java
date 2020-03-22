package local.algorithm.leetcode;

public class FindArraySameLength {

    public int findLength(int[] A, int[] B) {
        int[][] checkSame = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                int a = A[i - 1];
                int b = B[j - 1];
                if (a == b) {
                    checkSame[i][j] = checkSame[i - 1][j - 1] + 1;
                } else {
                    checkSame[i][j] = 0;
                }
                max = Math.max(max, checkSame[i][j]);
            }
        }
        return max;
    }
}
