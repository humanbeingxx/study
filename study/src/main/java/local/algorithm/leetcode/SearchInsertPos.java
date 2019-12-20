package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class SearchInsertPos {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1, pos = -1;
        while (low <= high) {
            pos = (low + high) / 2;
            if (target == nums[pos]) {
                return pos;
            } else if (target > nums[pos]) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        if (nums[pos] > target) {
            return pos;
        } else {
            return pos + 1;
        }
    }
}
