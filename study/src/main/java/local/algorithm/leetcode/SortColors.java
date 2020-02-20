package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-20
 **/
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int low = 0, high = nums.length - 1, index = 0;
        while (index <= high) {
            int num = nums[index];
            if (num == 0) {
                exchange(nums, low, index);
                low++;
                index++;
            } else if (num == 2) {
                exchange(nums, high, index);
                high--;
            } else {
                index++;
            }
        }
    }

    private void exchange(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
