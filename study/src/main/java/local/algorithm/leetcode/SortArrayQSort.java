package local.algorithm.leetcode;

import local.algorithm.leetcode.sort.SortArray;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/27 16:38
 */
public class SortArrayQSort implements SortArray {

    @Override
    public void sortArray(int[] nums) {
        sortRec(nums, 0, nums.length - 1);
    }

    private void sortRec(int[] nums, int from, int to) {
        if (from >= to) {
            return;
        }
        int pivot = nums[from];
        int i = from, j = to;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = pivot;
        sortRec(nums, from, i - 1);
        sortRec(nums, i + 1, to);
    }
}
