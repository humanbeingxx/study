package local.algorithm.leetcode;

import java.util.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/17 0:21
 */
public class ThreeSumZero {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return new ArrayList<>(result);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return new ArrayList<>(result);
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            findSumTwo(nums, i + 1, nums.length - 1, target, result);
        }
        return new ArrayList<>(result);
    }

    private void findSumTwo(int[] nums, int start, int end, int target, List<List<Integer>> result) {
        int i = start, j = end;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                List<Integer> oneResult = new ArrayList<>();
                oneResult.add(-target);
                oneResult.add(nums[i]);
                oneResult.add(nums[j]);
                result.add(oneResult);
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (j > i && nums[j] == nums[j - 1]) {
                    j--;
                }
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}
