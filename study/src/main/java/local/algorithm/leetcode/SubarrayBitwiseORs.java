package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class SubarrayBitwiseORs {

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> pre = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        pre.add(0);
        for (int a : A) {
            curr.clear();
            curr.add(a);
            for (Integer preVal : pre) {
                curr.add(preVal | a);
            }
            result.addAll(curr);
            pre.clear();
            pre.addAll(curr);
        }
        return result.size();
    }

}
