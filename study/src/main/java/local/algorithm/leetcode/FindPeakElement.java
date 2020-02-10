package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int low = 0, high = nums.length, mid = low + (high - low) / 2;
        while (low < high) {
            int check = checkPeak(nums, mid);
            if (check == 0) {
                return mid;
            } else if (check == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }

        return low;
    }

    private int checkPeak(int[] nums, int index) {
        if (index == 0) {
            if (nums[index] > nums[index + 1]) {
                return 0;
            } else {
                return 1;
            }
        }
        if (index == nums.length - 1) {
            if (nums[index] > nums[index - 1]) {
                return 0;
            } else {
                return -1;
            }
        }
        if (nums[index] > nums[index+1] && nums[index] > nums[index-1]) {
            return 0;
        } else if (nums[index] < nums[index+1] && nums[index] > nums[index-1]) {
            return 1;
        } else if (nums[index] > nums[index+1] && nums[index] < nums[index-1]) {
            return -1;
        } else if (nums[index] < nums[index+1] && nums[index] < nums[index-1]) {
            return -1;
        }

        //cannot reach;
        return 0;
    }
}
