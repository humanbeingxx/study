package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre || count == 0) {
                count++;
                if (count == 1) {
                    pre = nums[i];
                }
            } else {
                count--;
            }
        }
        return pre;
    }
}
