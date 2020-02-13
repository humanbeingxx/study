package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-13
 **/
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(0, k, 0, n, temp, result);
        return result;
    }

    private void rec(int i, int k, int sum, int target, List<Integer> temp, List<List<Integer>> result) {
        if (sum > target || (k == 0 && sum != target)) {
            return;
        }
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i + 1; j <= 9; j++) {
            temp.add(j);
            rec(j, k - 1, sum + j, target, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
