package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(nums, 0, temp, result);
        return result;
    }

    private void rec(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        if (start == nums.length) {
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (temp.size() > 0 && nums[i] < temp.get(temp.size() - 1) || used.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            used.add(nums[i]);
            if (temp.size() > 1) {
                result.add(new ArrayList<>(temp));
            }
            rec(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
