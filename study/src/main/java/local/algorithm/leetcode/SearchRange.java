package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = searchFirst(nums, target);
        int right = searchLast(nums, target);
        return new int[]{left, right};
    }

    int searchFirst(int[] nums, int target) {
        int low = 0, high = nums.length, mid = low + (high - low) / 2;
        while (low < high) {
            int val = nums[mid];
            if (val >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }
        if (low < nums.length && nums[low] == target) {
            return low;
        } else {
            return -1;
        }
    }


    int searchLast(int[] nums, int target) {
        int low = 0, high = nums.length, mid = low + (high - low) / 2;
        while (low < high) {
            int val = nums[mid];
            if (val <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
            mid = low + (high - low) / 2;
        }
        if (low > 0 && nums[low - 1] == target) {
            return low - 1;
        } else {
            return -1;
        }
    }
}
