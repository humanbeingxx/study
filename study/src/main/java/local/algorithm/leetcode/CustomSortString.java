package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class CustomSortString {

    public String customSortString(String S, String T) {
        int[] indices = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            indices[c - 'a'] = i + 1;
        }
        Character[] chars = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            chars[i] = T.charAt(i);
        }
        Arrays.sort(chars, Comparator.comparingInt(o -> indices[o - 'a']));
        StringBuilder sb = new StringBuilder(chars.length);
        for (Character aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    public String customSortString2(String S, String T) {
        int[] counts = new int[26];
        for (int i = 0; i < T.length(); i++) {
            counts[T.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int count = counts[S.charAt(i) - 'a'];
            for (int j = 0; j < count; j++) {
                sb.append(S.charAt(i));
            }
            counts[S.charAt(i) - 'a'] = 0;
        }
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}
