package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int remainCount = 0, preEnd = -1;
        for (int[] interval : intervals) {
            if (preEnd == - 1) {
                preEnd = interval[1];
                remainCount++;
            } else if (interval[0] >= preEnd) {
                preEnd = interval[1];
                remainCount++;
            }
        }
        return intervals.length - remainCount;
    }
}
