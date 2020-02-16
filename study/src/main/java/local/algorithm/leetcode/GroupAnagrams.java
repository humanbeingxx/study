package local.algorithm.leetcode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-16
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        String[] counts = countAsString(strs);
        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            groups.putIfAbsent(counts[i], new ArrayList<>());
            groups.get(counts[i]).add(strs[i]);
        }
        return new ArrayList<>(groups.values());
    }

    private String[] countAsString(String[] strs) {
        String[] counts = new String[strs.length];
        int[] count = new int[26];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                count[str.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int ct : count) {
                if (ct == 0) {
                    sb.append(',');
                } else {
                    sb.append(ct).append(',');
                }
            }
            sb.setLength(sb.length() - 1);
            counts[i] = sb.toString();
            Arrays.fill(count, 0);
        }
        return counts;
    }
}
