package local.algorithm.leetcode;

import java.util.Arrays;

public class FindHeaterRadius {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int minRadius = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index >= 0) {
                continue;
            }
            int bigger = -(index + 1);
            int left = bigger > 0 ? house - heaters[bigger - 1] : Integer.MAX_VALUE;
            int right = bigger < heaters.length ? heaters[bigger] - house : Integer.MAX_VALUE;
            minRadius = Math.max(minRadius, Math.min(left, right));
        }
        return minRadius;
    }
}
