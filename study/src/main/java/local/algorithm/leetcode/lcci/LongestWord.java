package local.algorithm.leetcode.lcci;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/19 20:53
 */
public class LongestWord {

    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            }
        });
        for (String word : words) {
            if (checkWord(word, wordSet)) {
                return word;
            }
        }
        return "";
    }

    private boolean checkWord(String word, Set<String> wordSet) {
        for (int i = 0; i < word.length() - 1; i++) {
            String prefix = word.substring(0, i + 1);
            if (wordSet.contains(prefix)) {
                String left = word.substring(i + 1);
                if (checkWordLeft(left, wordSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWordLeft(String word, Set<String> wordSet) {
        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i + 1);
            if (wordSet.contains(prefix)) {
                String left = word.substring(i + 1);
                if (left.isEmpty() || checkWordLeft(left, wordSet)) {
                    return true;
                }
            }
        }
        return false;
    }
}
