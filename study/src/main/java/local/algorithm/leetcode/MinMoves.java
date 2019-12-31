package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class MinMoves {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int sum = 0;
        for (int num : nums) {
            sum += (num - min);
        }
        return sum;
    }
}
