package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (counter.containsKey(c)) {
                counter.put(c, counter.get(c) + 1);
            } else {
                counter.put(c, 1);
            }
        }
        boolean hasOdd = false;
        int len = 0;
        for (Integer value : counter.values()) {
            if (value % 2 == 1) {
                if (!hasOdd) {
                    hasOdd = true;
                    len += value;
                } else {
                    len += value - 1;
                }
            } else {
                len += value;
            }
        }
        return len;
    }
}
