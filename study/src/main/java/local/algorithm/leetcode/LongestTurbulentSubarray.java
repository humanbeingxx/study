package local.algorithm.leetcode;

import java.util.Arrays;

public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int[] sizes = new int[arr.length];
        Arrays.fill(sizes, 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                if (sizes[i-1] < 0) {
                    sizes[i] = -sizes[i-1] + 1;
                } else {
                    sizes[i] = 2;
                }
            } else if (arr[i] < arr[i-1]) {
                if (sizes[i-1] >0) {
                    sizes[i] = -sizes[i-1]-1;
                } else {
                    sizes[i] = -2;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < sizes.length; i++) {
            max = Math.max(max, Math.abs(sizes[i]));
        }
        return max;
    }
}
