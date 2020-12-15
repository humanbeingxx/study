package local.algorithm.leetcode.lcci;

import java.util.Arrays;

public class SubSort {

    public int[] subSort(int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        Arrays.sort(copy);
        int m = -1, n = -1;
        for (int i = 0; i < array.length; i++) {
            if (copy[i] != array[i]) {
                if (m == -1) {
                    m = i;
                } else {
                    n = i;
                }
            }
        }
        if (m == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{m, n};
        }
    }
}
