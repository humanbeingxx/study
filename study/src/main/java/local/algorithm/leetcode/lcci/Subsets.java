package local.algorithm.leetcode.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/20 16:25
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        collect(nums, 0, temp, result);
        return result;
    }

    private void collect(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        collect(nums, index + 1, temp, result);
        temp.remove(temp.size() - 1);
        collect(nums, index+1, temp, result);
    }
}
