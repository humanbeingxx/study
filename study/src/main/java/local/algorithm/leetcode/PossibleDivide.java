package local.algorithm.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class PossibleDivide {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        while (true) {
            if (counts.isEmpty()) {
                return true;
            }
            int first = counts.entrySet().iterator().next().getKey();
            for (int i = 0; i < k; i++) {
                if (!counts.containsKey(first + i)) {
                    return false;
                }
                int count = counts.get(first + i);
                if (count == 1) {
                    counts.remove(first + i);
                } else {
                    counts.put(first + i, count - 1);
                }
            }
        }
    }
}
