package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[0][2];
        }
        int indexA = 0, indexB = 0;
        List<int[]> result = new ArrayList<>();
        while (indexA < A.length && indexB < B.length) {
            int[] intersection = intersect(A[indexA], B[indexB]);
            if (intersection != null) {
                result.add(intersection);
            }
            if (A[indexA][1] > B[indexB][1]) {
                indexB++;
            } else if (A[indexA][1] < B[indexB][1]) {
                indexA++;
            } else {
                indexA++;
                indexB++;
            }
        }
        return result.toArray(new int[0][2]);
    }

    private int[] intersect(int[] a, int[] b) {
        if (a[0] > b[1] || b[0] > a[1]) {
            return null;
        }
        int left = Math.max(a[0], b[0]);
        int right = Math.min(a[1], b[1]);
        return new int[]{left, right};
    }
}
