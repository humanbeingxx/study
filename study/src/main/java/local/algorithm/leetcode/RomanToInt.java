package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 21:18
 */
public class RomanToInt {

    Map<String, Integer> values = new HashMap<>();
    Map<String, Integer> special = new HashMap<>();

    {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);

        special.put("IV", 4);
        special.put("IX", 9);
        special.put("XL", 40);
        special.put("XC", 90);
        special.put("CD", 400);
        special.put("CM", 900);
    }

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i > 0) {
                String c2 = s.substring(i - 1, i + 1);
                Integer specialValue = special.get(c2);
                if (specialValue != null) {
                    sum += specialValue;
                    i--;
                } else {
                    sum += values.get(s.substring(i, i + 1));
                }
            } else {
                sum += values.get(s.substring(0, 1));
            }
        }
        return sum;
    }
}
