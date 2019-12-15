package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 16:33
 */
public class ThirdMax {

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num == first) {
                continue;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num == second) {
                continue;
            } else if (num > third) {
                third = num;
            }
        }
        if (third != Long.MIN_VALUE) {
            return (int) third;
        }
        return (int) first;
    }
}
