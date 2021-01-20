package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> deltaMap = new HashMap<>();
        int delta = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                delta--;
            } else {
                delta++;
            }
            if (delta == 0) {
                max = i + 1;
                continue;
            }
            if (deltaMap.containsKey(delta)) {
                max = Math.max(max, i - deltaMap.get(delta));
            } else {
                deltaMap.put(delta, i);
            }
        }
        return max;
    }
}
