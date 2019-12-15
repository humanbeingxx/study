package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 15:53
 */
public class LargestTimeFromDigits {

    public String largestTimeFromDigits(int[] A) {
        int len = A.length;
        int max = Integer.MIN_VALUE;
        int useI = -1, useJ = -1, useK = -1, useL = -1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < len; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    for (int l = 0; l < len; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        int value = value(A[i], A[j], A[k], A[l]);
                        if (valid(A[i], A[j], A[k], A[l]) && value > max) {
                            max = value;
                            useI = i;
                            useJ = j;
                            useK = k;
                            useL = l;
                        }
                    }
                }
            }
        }
        if (useI < 0 || useJ < 0 || useK < 0 || useL < 0) {
            return "";
        }
        return "" + A[useI] + A[useJ] + ":" + A[useK] + A[useL];
    }

    private int value(int i, int j, int k, int l) {
        return i * 1000 + j * 100 + k * 10 + l;
    }

    private boolean valid(int i, int j, int k, int l) {
        if (i > 2) {
            return false;
        }
        if (i == 2 && j > 3) {
            return false;
        }
        return k <= 5;
    }
}
