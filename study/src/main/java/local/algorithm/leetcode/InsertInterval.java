package local.algorithm.leetcode;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int findLeft = find(intervals, newInterval, 0);
        int mergeLeft = findLeft < 0 ? -findLeft - 2 : findLeft;
        int findRight = find(intervals, newInterval, 1);
        int mergeRight = findRight < 0 ? -findRight - 1 : findRight;
        int[][] result;
        if (mergeLeft >= 0 && mergeRight < intervals.length) {
            int[] left = intervals[mergeLeft];
            int[] right = intervals[mergeRight];
            boolean touchLeft = left[1] >= newInterval[0];
            boolean touchRight = right[0] <= newInterval[1];
            if (touchLeft && touchRight) {
                result = new int[mergeLeft + intervals.length - mergeRight][2];
                System.arraycopy(intervals, 0, result, 0, mergeLeft);
                result[mergeLeft] = new int[]{left[0], right[1]};
                System.arraycopy(intervals, mergeRight + 1, result, mergeLeft + 1, intervals.length - mergeRight - 1);
            } else if (touchLeft) {
                result = new int[mergeLeft + intervals.length - mergeRight + 1][2];
                System.arraycopy(intervals, 0, result, 0, mergeLeft);
                result[mergeLeft] = new int[]{left[0], newInterval[1]};
                System.arraycopy(intervals, mergeRight, result, mergeLeft + 1, intervals.length - mergeRight);
            } else if (touchRight) {
                result = new int[mergeLeft + 1 + intervals.length - mergeRight][2];
                System.arraycopy(intervals, 0, result, 0, mergeLeft + 1);
                result[mergeLeft + 1] = new int[]{newInterval[0], right[1]};
                System.arraycopy(intervals, mergeRight + 1, result, mergeLeft + 2, intervals.length - mergeRight - 1);
            } else {
                result = new int[mergeLeft + 1 + intervals.length - mergeRight + 1][2];
                System.arraycopy(intervals, 0, result, 0, mergeLeft + 1);
                result[mergeLeft + 1] = newInterval;
                System.arraycopy(intervals, mergeRight, result, mergeLeft + 2, intervals.length - mergeRight);

            }
        } else if (mergeLeft >= 0) {
            int[] left = intervals[mergeLeft];
            int[] merge = mergeByLeft(left, newInterval);
            if (merge == null) {
                result = new int[mergeLeft + 2][2];
                System.arraycopy(intervals, 0, result, 0, mergeLeft + 1);
                result[result.length - 1] = newInterval;
            } else {
                result = new int[mergeLeft + 1][2];
                System.arraycopy(intervals, 0, result, 0, mergeLeft);
                result[result.length - 1] = merge;
            }
        } else if (mergeRight < intervals.length) {
            int[] right = intervals[mergeRight];
            int[] merge = mergeByRight(newInterval, right);
            if (merge == null) {
                result = new int[intervals.length - mergeRight + 1][2];
                result[0] = newInterval;
                System.arraycopy(intervals, mergeRight, result, 1, intervals.length - mergeRight);
            } else {
                result = new int[intervals.length - mergeRight][2];
                result[0] = merge;
                System.arraycopy(intervals, mergeRight + 1, result, 1, intervals.length - mergeRight - 1);
            }
        } else {
            result = new int[1][2];
            result[0] = newInterval;
        }
        return result;
    }

    // a.left < b.left
    private int[] mergeByLeft(int[] a, int[] b) {
        if (b[0] > a[1]) {
            return null;
        }
        int left = a[0], right = Math.max(a[1], b[1]);
        return new int[]{left, right};
    }

    // a.right < b.right
    private int[] mergeByRight(int[] a, int[] b) {
        if (b[0] > a[1]) {
            return null;
        }
        int left = Math.min(a[0], b[0]), right = b[1];
        return new int[]{left, right};
    }

    private int find(int[][] intervals, int[] newInterval, int pos) {
        int low = 0, high = intervals.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (intervals[mid][pos] == newInterval[pos]) {
                return mid;
            } else if (intervals[mid][pos] < newInterval[pos]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
}
