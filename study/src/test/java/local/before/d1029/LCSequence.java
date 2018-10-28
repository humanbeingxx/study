package local.before.d1029;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/29 上午12:22
 **/
public class LCSequence {

    // trans[i][j]为一个以str1[i]和str1[j]结尾的子串相等的最大长度

    public static int length(String str1, String str2) {
        int[][] trans = new int[str1.length()][str2.length()];

        int maxLen = 0;

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        trans[i][j] = trans[i - 1][j - 1] + 1;
                    } else {
                        trans[i][j] = 1;
                    }
                }
                if (trans[i][j] > maxLen) {
                    maxLen = trans[i][j];
                }
            }
        }

        return maxLen;
    }

    public static Pair<Integer, Integer> pos(String str1, String str2) {
        int[][] trans = new int[str1.length()][str2.length()];

        int pos = -1;
        int maxLen = 0;

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        trans[i][j] = trans[i - 1][j - 1] + 1;
                    } else {
                        trans[i][j] = 1;
                    }
                }
                if (trans[i][j] > maxLen) {
                    pos = i;
                    maxLen = trans[i][j];
                }
            }
        }

        return Pair.of(pos, maxLen);
    }
}
