package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class SumPivotIndex {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = 0, index = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        while (index < nums.length - 1) {
            if (left == right) {
                return index;
            }
            left += nums[index];
            right -= nums[index + 1];
            index++;
        }
        if (left == 0) {
            return index;
        }
        return -1;
    }

}
