package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        if (set.size() > candies.length / 2) {
            return candies.length / 2;
        } else {
            return set.size();
        }
    }
}
