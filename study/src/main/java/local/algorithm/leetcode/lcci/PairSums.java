package local.algorithm.leetcode.lcci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PairSums {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            int diff = target - num;
            if (diffMap.containsKey(diff) && diffMap.get(diff) > 0) {
                result.add(pair(num, diff));
                diffMap.put(diff, diffMap.get(diff) - 1);
            } else {
                diffMap.put(num, diffMap.getOrDefault(num, 0) + 1);
            }
        }
        return result;
    }

    private List<Integer> pair(int a, int b) {
        List<Integer> pair = new ArrayList<>();
        pair.add(a);
        pair.add(b);
        return pair;
    }
}
