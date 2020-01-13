package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class MaxSharedSubString {

    public String searchSubString(String a, String b) {
        String source, target;
        if (a.length() < b.length()) {
            source = a;
            target = b;
        } else {
            source = b;
            target = a;
        }
        int notMatch = 0;
        for (; notMatch < source.length(); notMatch++) {
            for (int start = 0, end = source.length() - notMatch; end < source.length(); start++, end++) {
                String sub = source.substring(start, end);
                if (target.contains(sub)) {
                    return sub;
                }
            }
        }
        return "";
    }

    //TODO 动态规划
}
