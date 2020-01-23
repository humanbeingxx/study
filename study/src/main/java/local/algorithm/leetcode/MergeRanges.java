package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cuixiaoshuang
 * @date 2020-01-20
 **/
public class MergeRanges {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = intervals[i - 1];
            int[] curr = intervals[i];
            if (curr[0] > pre[1]) {
                continue;
            }
            intervals[i - 1] = null;
            curr[0] = pre[0];
            curr[1] = Math.max(pre[1], curr[1]);
        }
        int count = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                count++;
            }
        }
        int[][] result = new int[count][2];
        int index = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                result[index++] = interval;
            }
        }
        return result;
    }
}
