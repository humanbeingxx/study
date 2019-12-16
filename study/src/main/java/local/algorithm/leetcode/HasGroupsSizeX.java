package local.algorithm.leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class HasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : deck) {
            if (!counts.containsKey(i)) {
                counts.put(i, 1);
            } else {
                counts.put(i, counts.get(i) + 1);
            }
        }
        Collection<Integer> values = counts.values();
        int min = Collections.min(values);
        int i = 2;
        for (; i <= min; i++) {
            boolean failed = false;
            for (Integer value : values) {
                if (value % i != 0) {
                    failed = true;
                    break;
                }
            }
            if (!failed) {
                return true;
            }
        }
        return false;
    }
}
