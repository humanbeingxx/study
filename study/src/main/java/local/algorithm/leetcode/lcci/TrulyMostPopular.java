package local.algorithm.leetcode.lcci;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrulyMostPopular {

    private final Pattern pattern = Pattern.compile("([^(]+)\\((\\d+)\\)");

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, String> unionSet = createUnionSet(synonyms);
        Map<String, Integer> resultMap = new HashMap<>();
        for (String name : names) {
            Matcher matcher = pattern.matcher(name);
            matcher.find();
            String realName = matcher.group(1);
            String rootName = find(unionSet, realName);
            int count = Integer.parseInt(matcher.group(2));
            if (rootName == null) {
                resultMap.put(realName, count);
                continue;
            }
            if (!resultMap.containsKey(rootName)) {
                resultMap.put(rootName, count);
            } else {
                resultMap.put(rootName, resultMap.get(rootName) + count);
            }
        }
        String[] result = new String[resultMap.size()];
        Iterator<Map.Entry<String, Integer>> iterator = resultMap.entrySet().iterator();
        for (int i = 0; i < result.length; i++) {
            Map.Entry<String, Integer> entry = iterator.next();
            result[i] = entry.getKey() + "(" + entry.getValue() + ")";
        }
        return result;
    }

    private Map<String, String> createUnionSet(String[] synonyms) {
        Map<String, String> unionSet = new HashMap<>();
        for (String synonym : synonyms) {
            String[] split = synonym.replaceAll("[()]", "").split(",");
            if (!unionSet.containsKey(split[0])) {
                unionSet.put(split[0], split[0]);
            }
            if (!unionSet.containsKey(split[1])) {
                unionSet.put(split[1], split[1]);
            }
            merge(unionSet, split[0], split[1]);
        }
        return unionSet;
    }

    private void merge(Map<String, String> unionSet, String a, String b) {
        String aRoot = find(unionSet, a);
        String bRoot = find(unionSet, b);
        if (aRoot.compareTo(bRoot) < 0) {
            unionSet.put(bRoot, aRoot);
        } else {
            unionSet.put(aRoot, bRoot);
        }
    }

    private String find(Map<String, String> unionSet, String target) {
        if (!unionSet.containsKey(target)) {
            return null;
        }
        while (!unionSet.get(target).equals(target)) {
            target = unionSet.get(target);
        }
        return target;
    }
}
