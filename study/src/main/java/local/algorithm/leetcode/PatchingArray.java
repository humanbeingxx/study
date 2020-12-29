package local.algorithm.leetcode;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        // [1,X] -> [1, 2X-1]
        int index = 0, num = 1, added = 0;
        while (num <= n) {
            if (index < nums.length && num >= nums[index]) {
                num += nums[index];
                index++;
            } else {
                added++;
                num *= 2;
            }
        }
        return added;
    }

}
