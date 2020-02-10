package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(candidates, 0, 0, target, temp, result);
        return result;
    }

    private void rec(int[] candidates, int index, int sum, int target, List<Integer> temp, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
        } else if (sum > target || index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            rec(candidates, i, sum + candidates[i], target, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
