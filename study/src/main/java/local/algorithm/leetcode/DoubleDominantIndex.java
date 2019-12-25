package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class DoubleDominantIndex {

    public int dominantIndex(int[] nums) {
        int top1 = Integer.MIN_VALUE, top2 = Integer.MIN_VALUE;
        int top1Index = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > top1) {
                top2 = top1;
                top1 = num;
                top1Index = i;
            } else if (num > top2) {
                top2 = num;
            }
        }
        if (top1 >= top2 * 2) {
            return top1Index;
        } else {
            return -1;
        }
    }
}
