package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxEvents {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        Set<Integer> used = new HashSet<>();
        for (int[] event : events) {
            for (int i = event[0]; i <= event[1]; i++) {
                if (used.add(i)) {
                    break;
                }
            }
        }
        return used.size();
    }
}
