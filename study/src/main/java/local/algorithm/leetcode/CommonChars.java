package local.algorithm.leetcode;

import java.util.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 15:15
 */
public class CommonChars {

    public List<String> commonChars(String[] A) {
        Map<Character, Integer> intersectCount = new HashMap<>();
        Map<Character, Integer> currCount = new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) {
            intersectCount.put(A[0].charAt(i), intersectCount.getOrDefault(A[0].charAt(i), 0) + 1);
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                currCount.put(A[i].charAt(j), currCount.getOrDefault(A[i].charAt(j), 0) + 1);
            }
            Iterator<Map.Entry<Character, Integer>> iterator = intersectCount.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                if (currCount.containsKey(entry.getKey())) {
                    entry.setValue(Math.min(entry.getValue(), currCount.get(entry.getKey())));
                } else {
                    iterator.remove();
                }
            }
            currCount.clear();
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : intersectCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey() + "");
            }
        }
        return result;
    }
}
