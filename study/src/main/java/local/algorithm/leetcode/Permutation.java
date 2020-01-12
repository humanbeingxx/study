package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/13 0:32
 */
public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        inner(nums, new int[len], new ArrayList<>(), result);
        return result;
    }

    private void inner(int[] nums, int[] used, List<Integer> oneResult, List<List<Integer>> results) {
        if (oneResult.size() == nums.length) {
            results.add(new ArrayList<>(oneResult));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            oneResult.add(nums[i]);
            inner(nums, used, oneResult, results);
            used[i] = 0;
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
