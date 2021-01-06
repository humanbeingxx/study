package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        if (length == 0) {
            return 1;
        }
        int count = 0;
        Map<Integer, Integer> part = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                part.put(a + b, part.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                if (part.containsKey(-(c + d))) {
                    count += part.get(-(c + d));
                }
            }
        }
        return count;
    }
}
