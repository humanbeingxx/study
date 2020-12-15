package local.algorithm.leetcode.lcof;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/14 20:44
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return reversePairs(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums, left, mid, temp);
        int rightCount = reversePairs(nums, mid + 1, right, temp);
        int crossCount = 0;
        if (nums[mid] > nums[mid + 1]) {
            crossCount = merge(nums, left, mid, right, temp);
        }
        return leftCount + rightCount + crossCount;
    }

    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        int pos = left, i = left, j = mid + 1, count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[pos++] = nums[i++];
            } else {
                temp[pos++] = nums[j++];
                count += (mid + 1 - i);
            }
        }
        while (i <= mid) {
            temp[pos++] = nums[i++];
        }
        while (j <= right) {
            temp[pos++] = nums[j++];
        }
        System.arraycopy(temp, left, nums, left, right - left + 1);
        return count;
    }
}
