package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-08
 **/
public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < Math.min(nums.length, i + k + 1); j++) {
                int v1 = nums[i];
                int v2 = nums[j];
                if (v1 - (long)v2 <= t && v2 - (long)v1 <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    //TODO
    public boolean containsNearbyAlmostDuplicateBetter(int[] nums, int k, int t) {
        return false;
    }
}
