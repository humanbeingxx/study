package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class PartitionEqualSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[] happened = new boolean[half + 1];
        happened[0] = true;
        for (int num : nums) {
            for (int i = half; i >= num; i--) {
                if (happened[i - num]) {
                    happened[i] = true;
                }
            }
        }
        return happened[half];
    }
}
