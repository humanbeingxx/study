package local.algorithm.leetcode;

public class FindUnsortedSubarray2 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int currMax = nums[0], up = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < currMax) {
                up = i;
            } else {
                currMax = num;
            }
        }
        if (up == 0) {
            return 0;
        }
        int currMin = nums[nums.length - 1], down = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            if (num > currMin) {
                down = i;
            } else {
                currMin = num;
            }
        }
        return up - down + 1;
    }
}
