package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 16:14
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int from = 0, to = nums.length - 1;
        int count = 0;
        int temp;
        while (from <= to) {
            while (from < to && nums[from] != val) {
                from++;
            }
            if (nums[from] == val) {
                count++;
            }
            if (from == to) {
                break;
            }

            while (to > from && nums[to] == val) {
                count++;
                to--;
            }
            if (from == to) {
                break;
            }
            temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
        return nums.length - count;
    }
}
