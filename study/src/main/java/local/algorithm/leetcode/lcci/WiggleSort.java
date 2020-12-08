package local.algorithm.leetcode.lcci;

public class WiggleSort {

    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                //top
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i - 1, i);
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i - 1, i);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
