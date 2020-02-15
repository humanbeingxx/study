package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int close = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= close) {
                close = i;
            }
        }
        return close == 0;
    }

}
