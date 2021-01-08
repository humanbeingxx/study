package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> appearance = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int sub = k - num;
            Integer exist = appearance.get(sub);
            if (exist != null && exist > 0) {
                count++;
                appearance.put(sub, exist - 1);
            } else {
                appearance.put(num, appearance.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
