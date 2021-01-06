package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> saw = new HashSet<>();
        for (int num : nums) {
            if (saw.contains(num)) {
                return true;
            } else {
                saw.add(num);
            }
        }
        return false;
    }
}
