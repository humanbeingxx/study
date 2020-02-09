package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-09
 **/
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                break;
            }
        }
        if (i >= 0) {
            int j = nums.length - 1;
            for (; j > i; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        Arrays.sort(nums, i + 1, nums.length);
    }

}
