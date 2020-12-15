package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/8 20:14
 */
public class FindClosest {

    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> indices = makeIndex(words);
        return minDistance(indices.get(word1), indices.get(word2));
    }

    private Map<String, List<Integer>> makeIndex(String[] words) {
        Map<String, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            indices.putIfAbsent(word, new ArrayList<>());
            indices.get(word).add(i);
        }
        return indices;
    }

    private int minDistance(List<Integer> pos1, List<Integer> pos2) {
        int min =Integer.MAX_VALUE;
        int distance;
        for (int i1 = 0, i2 = 0; i1 < pos1.size() && i2 < pos2.size();) {
            distance = pos1.get(i1) - pos2.get(i2);
            if (distance == 0) {
                return 0;
            } else if (distance > 0) {
                i2++;
            } else {
                i1++;
            }
            min = Math.min(min, Math.abs(distance));
        }
        return min;
    }
}
