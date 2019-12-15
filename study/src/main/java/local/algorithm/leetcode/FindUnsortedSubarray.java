package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 21:07
 */
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int from = 0, to = nums.length - 1;
        for (; from < nums.length; from++) {
            if (nums[from] != copy[from]) {
                break;
            }
        }
        for (; to > from; to--) {
            if (nums[to] != copy[to]) {
                break;
            }
        }
        return to - from + 1;
    }
}
