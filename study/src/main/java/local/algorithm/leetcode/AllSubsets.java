package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-20
 **/
public class AllSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        List<List<Integer>> used = new ArrayList<>();
        List<List<Integer>> newUsed = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        List<Integer> newLast = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> arr = new ArrayList<>();
            arr.add(num);
            used.add(arr);
            last.add(i);
        }
        result.addAll(used);
        while (used.size() > 1) {
            for (int i = 0; i < used.size(); i++) {
                List<Integer> integers = used.get(i);
                int start = last.get(i) + 1;
                for (int j = start; j < nums.length; j++) {
                    List<Integer> arr = new ArrayList<>(integers);
                    arr.add(nums[j]);
                    newUsed.add(arr);
                    newLast.add(j);
                }
            }
            result.addAll(newUsed);
            used = newUsed;
            newUsed = new ArrayList<>();
            last = newLast;
            newLast = new ArrayList<>();
        }
        return result;
    }
}
