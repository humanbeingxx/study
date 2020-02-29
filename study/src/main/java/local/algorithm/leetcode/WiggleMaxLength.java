package local.algorithm.leetcode;

public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length <= 1) {
            return nums.length;
        }
        int len = 1;
        int direction = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                if (direction == 0) {
                    direction = 1;
                    len++;
                } else if (direction == -1) {
                    len++;
                    direction = 1;
                }
            } else if (nums[i] > nums[i-1]) {
                if (direction == 0) {
                    direction = -1;
                    len++;
                } else if (direction == 1) {
                    len++;
                    direction = -1;
                }
            }
        }
        return len;
    }
}
