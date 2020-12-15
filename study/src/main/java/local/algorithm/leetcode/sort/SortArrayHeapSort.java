package local.algorithm.leetcode.sort;

public class SortArrayHeapSort implements SortArray {

    @Override
    public void sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        makeHeap(nums);
        swap(nums, 0, nums.length - 1);
        for (int i = 1; i < nums.length; i++) {
            adjustHeap(nums, 0, nums.length - i);
            swap(nums, 0, nums.length - i - 1);
        }
    }

    private void makeHeap(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
    }

    private void adjustHeap(int[] nums, int start, int end) {
        for (; start < end; ) {
            int maxIndex = start;
            int leftIndex = start * 2 + 1;
            int rightIndex = start * 2 + 2;
            if (leftIndex >= end) {
                return;
            }
            if (nums[leftIndex] > nums[maxIndex]) {
                maxIndex = leftIndex;
            }
            if (rightIndex < end && nums[rightIndex] > nums[maxIndex]) {
                maxIndex = rightIndex;
            }
            if (maxIndex != start) {
                swap(nums, start, maxIndex);
            } else {
                return;
            }
            start = maxIndex;
        }
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
