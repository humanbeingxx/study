package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 21:35
 */
public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : arr) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
        return counter.values().size() == counter.values().stream().distinct().count();
    }
}
