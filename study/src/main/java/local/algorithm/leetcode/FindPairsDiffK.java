package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 21:42
 */
public class FindPairsDiffK {

    public int findPairs(int[] nums, int k) {
        Set<Integer> saw = new HashSet<>();
        Set<Integer> diff = new HashSet<>();

        for (int num : nums) {
            if (saw.contains(num - k)) {
                diff.add(num - k);
            }
            if (saw.contains(num + k)) {
                diff.add(num);
            }
            saw.add(num);
        }
        return diff.size();
    }
}
