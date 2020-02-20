package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-20
 **/
public class SearchRotatedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] == target) {
            return 0;
        }
        boolean inLeft = nums[0] < target;
        int low = 0, high = nums.length, mid = low + (high - low) / 2;
        while (low < high) {
            int num = nums[mid];
            boolean midInLeft = nums[0] < num;
            if (num == target) {
                return mid;
            } else if (num > target) {
                if ((inLeft && midInLeft) || (!inLeft && !midInLeft)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if ((inLeft && midInLeft) || (!inLeft && !midInLeft)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            mid = low + (high - low) / 2;
        }
        if (low >= nums.length || nums[low] != target) {
            return -1;
        } else {
            return low;
        }
    }
}
