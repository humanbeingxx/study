package local.algorithm.leetcode;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-22
 **/
public class FindLongestWord {

    public String findLongestWord(String s, List<String> d) {
        d.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o2.length() - o1.length();
            }
        });
        for (String sub : d) {
            if (contains(s, sub)) {
                return sub;
            }
        }
        return "";
    }

    boolean contains(String s, String sub) {
        int mainIndex = 0, subIndex = 0;
        for (; mainIndex < s.length() && subIndex < sub.length(); mainIndex++) {
            if (s.charAt(mainIndex) == sub.charAt(subIndex)) {
                subIndex++;
            }
        }
        return subIndex == sub.length();
    }
}
