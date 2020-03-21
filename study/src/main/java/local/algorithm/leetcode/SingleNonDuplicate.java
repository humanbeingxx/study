package local.algorithm.leetcode;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == nums[mid + 1]) {
                if ((mid - low) % 2 == 0) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if ((high - mid) % 2 == 0) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }

        }
        return nums[low];
    }
}
