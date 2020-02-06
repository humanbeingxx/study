package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-04
 **/
public class Find132pattern {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            min = Math.min(min, nums[i]);
            if (min == nums[i]) {
                continue;
            }
            for (int j = nums.length - 1; j > i; j--) {
                if (min < nums[j] && nums[j] < nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
