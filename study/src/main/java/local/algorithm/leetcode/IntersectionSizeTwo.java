package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 1:07
 */
public class IntersectionSizeTwo {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        int[] rec = {-1, -1};
        int res = 0;
        for (int[] is : intervals) {
            if (is[0] <= rec[0]) {
                continue;
            } else if (is[0] <= rec[1]) {
                res++;
                rec[0] = rec[1];
            } else {
                rec[0] = is[1] - 1;
                res += 2;
            }
            rec[1] = is[1];
        }
        return res;
    }
}
