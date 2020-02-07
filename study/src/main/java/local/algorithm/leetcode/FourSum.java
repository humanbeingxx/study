package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cuixiaoshuang
 * @date 2020-02-07
 **/
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int low = j + 1, high = nums.length - 1;
                int sub = target - nums[i] - nums[j];
                while (low < high) {
                    if (nums[low] + nums[high] < sub) {
                        low++;
                    } else if (nums[low] + nums[high] > sub) {
                        high--;
                    } else {
                        List<Integer> oneSet = new ArrayList<>();
                        oneSet.add(nums[i]);
                        oneSet.add(nums[j]);
                        oneSet.add(nums[low]);
                        oneSet.add(nums[high]);
                        result.add(oneSet);
                        if (nums[low] == nums[low + 1]) {
                            low += 2;
                        } else {
                            low += 1;
                        }
                        if (nums[high] == nums[high - 1]) {
                            high -= 2;
                        } else {
                            high -= 1;
                        }
                    }
                }
            }
        }

        return result.stream().distinct().collect(Collectors.toList());
    }
}
