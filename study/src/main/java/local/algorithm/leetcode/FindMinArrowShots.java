package local.algorithm.leetcode;

import java.util.Arrays;

public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int count = 1, arrow = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] > arrow) {
                count++;
                arrow = point[1];
            }
        }
        return count;
    }
}
