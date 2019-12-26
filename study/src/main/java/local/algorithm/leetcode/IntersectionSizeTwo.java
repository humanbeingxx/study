package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 1:07
 */
public class IntersectionSizeTwo {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int left = intervals[0][0];
        int right = left + 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] val = intervals[i];
            if (val[0] == right) {
                right++;
            } else if (val[0] > right) {
                right = val[0] + 1;
            } else {
                left = val[0];
            }
        }
        return right - left + 1;
    }
}
