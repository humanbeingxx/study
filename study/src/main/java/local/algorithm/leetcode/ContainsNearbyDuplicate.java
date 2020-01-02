package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0 || nums.length <= 1) {
            return false;
        }
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (window.contains(num)) {
                return true;
            }
            if (window.size() >= k) {
                window.remove(nums[i - k]);
            }
            window.add(num);
        }
        return false;
    }
}
