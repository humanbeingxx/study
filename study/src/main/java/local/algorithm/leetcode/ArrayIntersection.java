package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class ArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        set.retainAll(Arrays.stream(nums2).boxed().collect(Collectors.toSet()));
        int[] result = new int[set.size()];
        int idx = 0;
        for (Integer i : set) {
            result[idx++] = i;
        }
        return result;
    }
}
