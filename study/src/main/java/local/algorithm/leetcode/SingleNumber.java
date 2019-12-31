package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
