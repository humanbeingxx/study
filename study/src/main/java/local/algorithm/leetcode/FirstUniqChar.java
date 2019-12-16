package local.algorithm.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        Map<Character, Integer> saw = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (saw.containsKey(s.charAt(i))) {
                saw.put(s.charAt(i), i + s.length());
            } else {
                saw.put(s.charAt(i), i);
            }
        }
        if (saw.size() == 0) {
            return -1;
        }
        Integer min = Collections.min(saw.values());
        if (min >= s.length()) {
            return -1;
        } else {
            return min;
        }
    }
}
