package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/13 0:28
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int pos = Math.abs(num) - 1;
            if (nums[pos] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[pos] *= -1;
            }
        }
        return result;
    }
}
