package local.algorithm.leetcode;

import java.util.Arrays;

public class EraseOverlapIntervals2 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int removeCount = 0;
        int[] current = null;
        for (int[] interval : intervals) {
            if (current == null) {
                current = interval;
            } else {
                if (interval[0] >= current[1]) {
                    current = interval;
                } else {
                    removeCount++;
                    if (interval[1] < current[1]) {
                        current = interval;
                    }
                }
            }
        }
        return removeCount;
    }
}
