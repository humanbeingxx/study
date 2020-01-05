package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class KthLargest {

    private int[] heap;

    public KthLargest(int k, int[] nums) {
        heap = Arrays.copyOf(nums, k);
    }

    public int add(int val) {
        if (val < heap[0]) {
            return heap[0];
        } else {
            heap[0] = val;
        }
        adjust(heap);
        return heap[0];
    }

    public void adjust(int[] nums) {
        int start = nums.length / 2;
        while (start >= 0) {
            int left = 2 * start + 1;
            int right = 2 * start + 2;
            if (left >= nums.length) {
            } else if (right >= nums.length) {
                if (nums[start] < nums[left]) {
                    swap(nums, start, left);
                }
            } else {
                if (nums[left] >= nums[right]) {
                    if (nums[start] < nums[left]) {
                        swap(nums, start, left);
                    }
                } else {
                    if (nums[start] < nums[right]) {
                        swap(nums, start, right);
                    }
                }
            }
            adjustSub(nums, start);
            start--;
        }
    }

    private void adjustSub(int[] nums, int start) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        if (left >= nums.length) {
            return;
        }
        if (right >= nums.length) {
            if (nums[start] > nums[left]) {
                swap(nums, start, left);
            }
            adjustSub(nums, left);
        } else {
            if (nums[left] <= nums[right]) {
                if (nums[start] > nums[left]) {
                    swap(nums, start, left);
                }
            } else {
                if (nums[start] > nums[right]) {
                    swap(nums, start, right);
                }
            }
            adjustSub(nums, left);
            adjustSub(nums, right);
        }
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
