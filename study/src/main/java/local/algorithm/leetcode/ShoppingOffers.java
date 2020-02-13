package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2020-02-13
 **/
public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> calculated = new HashMap<>();
        return rec(price, special, needs, calculated);
    }

    private int rec(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> calculated) {
        if (calculated.containsKey(needs)) {
            return calculated.get(needs);
        }
        int total = buyNoPackage(price, needs);
        for (List<Integer> oneSep : special) {
            List<Integer> temp = new ArrayList<>(needs);
            int i = 0;
            for (; i < needs.size(); i++) {
                if (oneSep.get(i) > needs.get(i)) {
                    break;
                } else {
                    temp.set(i, temp.get(i) - oneSep.get(i));
                }
            }
            if (i == needs.size()) {
                total = Math.min(total, oneSep.get(i) + rec(price, special, temp, calculated));
            }
        }
        calculated.put(needs, total);
        return total;
    }

    private int buyNoPackage(List<Integer> price,List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}
