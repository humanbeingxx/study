package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-09
 **/
public class SubsetsWithNoDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        subRec(nums, 0, result, temp);
        return result;
    }

    private void subRec(int[] nums, int index, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            subRec(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
