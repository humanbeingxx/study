package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/13 0:32
 */
public class PermutationString {

    public String[] permutation(String s) {
        StringBuilder temp = new StringBuilder();
        Set<String> result = new HashSet<>();
        boolean[] used = new boolean[s.length()];
        inner(s.toCharArray(), used, temp, result);
        return result.toArray(new String[0]);
    }

    private void inner(char[] chars, boolean[] used, StringBuilder temp, Set<String> result) {
        if (temp.length() == chars.length) {
            result.add(temp.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.append(chars[i]);
                inner(chars, used, temp, result);
                temp.deleteCharAt(temp.length() - 1);
                used[i] = false;
            }
        }
    }

    public String[] permutationNoDup(String s) {
        StringBuilder temp = new StringBuilder();
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        makePermutation(s.toCharArray(), used, temp, result);
        return result.toArray(new String[0]);
    }

    private void makePermutation(char[] chars, boolean[] used, StringBuilder temp, List<String> result) {
        if (temp.length() == chars.length) {
            result.add(temp.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                temp.append(chars[i]);
                used[i] = true;
                makePermutation(chars, used, temp, result);
                temp.deleteCharAt(temp.length() - 1);
                used[i]= false;
            }
        }
    }
}
