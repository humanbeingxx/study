package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 15:37
 */
public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> counter = new HashMap<>();
        int temp;
        for (int[] dominoe : dominoes) {
            if (dominoe[0] > dominoe[1]) {
                temp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = temp;
            }
        }
        for (int[] dominoe : dominoes) {
            String key = dominoe[0] + "_" + dominoe[1];
            counter.put(key, counter.getOrDefault(key, 0) + 1);
        }

        return counter.values().stream().mapToInt(n -> (n * (n - 1)) / 2).sum();
    }
}
