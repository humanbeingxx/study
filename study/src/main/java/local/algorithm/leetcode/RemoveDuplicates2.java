package local.algorithm.leetcode;

public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums == null ? 0 : nums.length;
        }
        int writeIndex = 0, scanIndex = 1;
        for (; scanIndex < nums.length; scanIndex++) {
            if (nums[writeIndex] != nums[scanIndex]) {
                nums[++writeIndex] = nums[scanIndex];
            }
        }
        return writeIndex + 1;
    }
}
