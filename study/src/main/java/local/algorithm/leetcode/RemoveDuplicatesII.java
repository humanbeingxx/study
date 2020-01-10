package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int insertPos = 1, searchPos = 1;
        int currVal = nums[0], currHappen = 1;
        for (; searchPos < nums.length; searchPos++) {
            if (nums[searchPos] == currVal) {
                currHappen++;
                if (currHappen <= 2) {
                    nums[insertPos++] = nums[searchPos];
                }
            } else {
                currVal = nums[searchPos];
                currHappen = 1;
                nums[insertPos++] = nums[searchPos];
            }
        }
        return insertPos;
    }
}
