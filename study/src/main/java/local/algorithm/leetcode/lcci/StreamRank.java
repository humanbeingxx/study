package local.algorithm.leetcode.lcci;

import java.util.*;

public class StreamRank {

    List<Integer> sorted = new ArrayList<>();

    public StreamRank() {

    }

    public void track(int x) {
        int pos = binarySearch(x);
        if (pos < 0) {
            pos = -pos - 1;
        }
        sorted.add(pos, x);
    }

    public int getRankOfNumber(int x) {
        int pos = binarySearch(x+1);
        return pos >=0 ? pos : -pos - 1;
    }

    int binarySearch(int target) {
        int low = 0, high = sorted.size() - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            Integer midVal = sorted.get(mid);
            if (midVal > target) {
                high = mid - 1;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                if (low == high) {
                    return low;
                }
                high = mid;
            }
        }
        return low < sorted.size() && sorted.get(low) == target ? low : -(low + 1);
    }
}
