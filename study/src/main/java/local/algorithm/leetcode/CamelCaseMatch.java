package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CamelCaseMatch {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        if (pattern == null || pattern.isEmpty()) {
            for (int i = 0; i < queries.length; i++) {
                result.add(true);
            }
            return result;
        }
        String transPattern = "^" + pattern.replaceAll("", "[a-z]*?") + "$";
        Pattern compiledPattern = Pattern.compile(transPattern);
        for (String query : queries) {
            result.add(compiledPattern.matcher(query).find());
        }
        return result;
    }

    public List<Boolean> camelMatch2(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            result.add(match(queries[i], pattern));
        }
        return result;
    }

    private boolean match(String source, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return true;
        } else if (source == null || source.length() == 0) {
            return false;
        }
        int indexSource = 0, indexPattern = 0;
        while (indexPattern < pattern.length() && indexSource < source.length()) {
            if (source.charAt(indexSource) == pattern.charAt(indexPattern)) {
                indexSource++;
                indexPattern++;
            } else if (source.charAt(indexSource) >= 'a' && source.charAt(indexSource) <= 'z') {
                indexSource++;
            } else {
                return false;
            }
        }
        while (indexSource < source.length()) {
            if (source.charAt(indexSource) < 'a' || source.charAt(indexSource) > 'z') {
                return false;
            }
            indexSource++;
        }
        return indexPattern == pattern.length();
    }
}
