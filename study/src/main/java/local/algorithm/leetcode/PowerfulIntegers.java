package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        int i = 0;
        while (true) {
            int j = 0;
            int xPow = (int) Math.pow(x, i);
            if (xPow > bound) {
                break;
            }
            while (true) {
                int yPow = (int) Math.pow(y, j);
                if (yPow > bound - xPow) {
                    break;
                } else if (yPow <= bound - xPow) {
                    result.add(xPow + yPow);
                }
                j++;
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
            i++;
        }
        return new ArrayList<>(result);
    }
}
