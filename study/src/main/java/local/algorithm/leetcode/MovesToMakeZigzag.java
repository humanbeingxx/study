package local.algorithm.leetcode;

public class MovesToMakeZigzag {

    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int upMoves = 0;
        int left = nums[0];
        for (int i = 1; i < nums.length; i += 2) {
            upMoves += Math.max(0, left - nums[i] + 1);
            if (i < nums.length - 1) {
                upMoves += Math.max(0, nums[i + 1] - nums[i] + 1);
                left = Math.min(nums[i] - 1, nums[i + 1]);
            }
        }
        int downMoves = 0;
        downMoves += Math.max(0, nums[1] - nums[0] + 1);
        left = Math.min(nums[0] - 1, nums[1]);
        for (int i = 2; i < nums.length; i += 2) {
            downMoves += Math.max(0, left - nums[i] + 1);
            if (i < nums.length - 1) {
                downMoves += Math.max(0, nums[i + 1] - nums[i] + 1);
                left = Math.min(nums[i] - 1, nums[i + 1]);
            }
        }
        return Math.min(upMoves, downMoves);
    }
}
