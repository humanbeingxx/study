package local.algorithm.leetcode;

import java.util.*;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        rec(nums, used, temp, result);
        return result;
    }

    private void rec(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            rec(nums, used, temp, result);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
