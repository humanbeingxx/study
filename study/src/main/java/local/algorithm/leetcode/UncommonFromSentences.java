package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class UncommonFromSentences {

    public String[] uncommonFromSentences(String A, String B) {
        String[] splitA = A.split(" ");
        String[] splitB = B.split(" ");

        Map<String, Integer> counter = new HashMap<>();
        for (String s : splitA) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        for (String s : splitB) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        String[] result = new String[count];
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) {
                result[count - 1] = entry.getKey();
                count--;
            }
        }
        return result;
    }
}
