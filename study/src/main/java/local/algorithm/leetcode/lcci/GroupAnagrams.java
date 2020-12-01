package local.algorithm.leetcode.lcci;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new ArrayList<>());
            }
            groups.get(sorted).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
