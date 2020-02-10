package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        rec(candidates, 0, 0, target, temp, result);
        return result;
    }

    private void rec(int[] candidates, int index, int sum, int target, List<Integer> temp, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
        } else if (sum > target || index == candidates.length) {
            return;
        }
        int i = index;
        while (i < candidates.length) {
            temp.add(candidates[i]);
            rec(candidates, i + 1, sum + candidates[i], target, temp, result);
            temp.remove(temp.size() - 1);
            i++;

            while (i < candidates.length && i > 0 && candidates[i] == candidates[i - 1]) {
                i++;
            }
        }
    }
}
