package local.algorithm.leetcode;

import javafx.util.Pair;

import java.util.*;

public class KDiffPairs {

    public int findPairs(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        for (int num : nums) {
            int plus = num + k, minus = num - k;
            if (numSet.contains(plus)) {
                pairs.add(new Pair<>(num, plus));
            }
            if (numSet.contains(minus)) {
                pairs.add(new Pair<>(minus, num));
            }
            numSet.add(num);
        }
        return pairs.size();
    }
}
