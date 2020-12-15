package local.algorithm.leetcode;

public class ContainsPattern {

    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (isPattern(arr, i, m, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPattern(int[] arr, int startIndex, int m, int k) {
        if (startIndex + m >= arr.length) {
            return false;
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (startIndex + (i + 1) * m + j >= arr.length) {
                    return false;
                }
                if (arr[startIndex + j] != arr[startIndex + (i + 1) * m + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
