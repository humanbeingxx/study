package local.algorithm.leetcode.lcci;

import java.util.Arrays;

public class SmallestDifference {

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        boolean aGtB;
        int i = 0, j = 0;
        long min = Long.MAX_VALUE;
        while (true) {
            long ai = a[i], bj = b[j];
            min = Math.min(min, Math.abs(ai - bj));
            aGtB = ai >= bj;
            if (aGtB) {
                j++;
            } else {
                i++;
            }
            if (i == a.length || j == b.length) {
                break;
            }
        }
        if (i < a.length) {
            long bj = b[j - 1];
            while (i < a.length) {
                long ai = a[i];
                min = Math.min(min, Math.abs(ai - bj));
                i++;
            }
        } else if (j < b.length) {
            long ai = a[i - 1];
            while (j < b.length) {
                long bj = b[j];
                min = Math.min(min, Math.abs(ai - bj));
                j++;
            }
        }
        return min == 0x80000000L ? Integer.MIN_VALUE : (int) min;
    }

    int force(int[] a, int[] b) {
        long min = Integer.MAX_VALUE;
        for (int i : a) {
            for (int j : b) {
                min = Math.min(min, Math.abs((long) i - (long) j));
            }
        }
        return (int) min;
    }
}
