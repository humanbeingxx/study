package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            sum += i;
        }
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
