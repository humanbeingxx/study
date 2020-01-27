package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class CombineKFromN {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combineRec(1, n, k, temp, result);
        return result;
    }

    private void combineRec(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (start > n || k > n - start + 1) {
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            combineRec(i + 1, n, k - 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
