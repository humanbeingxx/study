package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 21:07
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int pre = 0, post = 1;
        while (post < nums.length) {
            if (nums[pre] != nums[post]) {
                pre++;
                nums[pre] = nums[post];
            }
            post++;
        }
        return pre + 1;
    }
}
