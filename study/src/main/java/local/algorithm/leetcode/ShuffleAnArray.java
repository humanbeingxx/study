package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

    private int[] nums;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < copy.length - 2; i++) {
            int randomPos = random.nextInt(copy.length - i - 1) + i + 1;
            swap(copy, i, randomPos);
        }
        return copy;
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
