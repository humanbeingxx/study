package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/25 22:19
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }

        Set<Character> patternSet = new HashSet<>();
        Set<String> strSet = new HashSet<>();
        Set<String> concat = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            patternSet.add(pattern.charAt(i));
            strSet.add(split[i]);
            concat.add(pattern.charAt(i) + "_" + split[i]);
        }
        return concat.size() == strSet.size() && strSet.size() == patternSet.size();
    }
}
