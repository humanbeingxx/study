package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 19:35
 */
public class MostCommonValidWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] split = paragraph.split("[!?',;. ]");
        Map<String, Integer> counter = new HashMap<>();
        for (String s : split) {
            s = s.trim().toLowerCase();
            if (s.isEmpty()) {
                continue;
            }
            if (counter.containsKey(s)) {
                counter.put(s, counter.get(s) + 1);
            } else {
                counter.put(s, 1);
            }
        }
        for (String ban : banned) {
            counter.remove(ban);
        }
        if (counter.isEmpty()) {
            return "";
        }
        Map.Entry<String, Integer> max = null;
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (max == null || max.getValue() < entry.getValue()) {
                max = entry;
            }
        }
        return max.getKey();
    }
}
