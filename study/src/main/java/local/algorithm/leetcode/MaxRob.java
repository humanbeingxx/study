package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class MaxRob {

    Map<Integer, Integer> calc = new HashMap<>();
    int count = 0;

    public int rob(int[] nums) {
        return calcI(0, nums);
    }

    private int calcI(int i, int[] nums) {
        count++;
        if (calc.get(i) != null) {
            return calc.get(i);
        }
        if (i >= nums.length) {
            return 0;
        }

        int robI = nums[i] + calcI(i + 2, nums);
        int robNoI = calcI(i + 1, nums);
        int rob = Math.max(robI, robNoI);
        calc.put(i, rob);
        return rob;
    }
}
