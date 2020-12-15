package local.algorithm.leetcode.sort;

public class SortArrayInsertSort implements SortArray {

    @Override
    public void sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = minIndex(nums, i);
            if (minIndex != i) {
                swap(nums, minIndex, i);
            }
        }
    }

    private int minIndex(int[] nums, int start) {
        int minIndex = start, minVal = nums[start];
        for (int i = start; i < nums.length; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
