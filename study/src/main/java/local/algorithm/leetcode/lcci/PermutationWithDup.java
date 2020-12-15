package local.algorithm.leetcode.lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/21 19:47
 */
public class PermutationWithDup {

    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] used = new boolean[chars.length];
        Arrays.sort(chars);
        StringBuilder temp = new StringBuilder();
        List<String> result = new ArrayList<>();
        doPermutation(chars, used, result, temp);
        return result.toArray(new String[0]);
    }

    private void doPermutation(char[] chars, boolean[] used, List<String> result, StringBuilder temp) {
        if (temp.length() == chars.length) {
            result.add(temp.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                if (i > 0 && !used[i - 1] && chars[i] == chars[i - 1]) {
                    continue;
                }
                temp.append(chars[i]);
                used[i] = true;
                doPermutation(chars, used, result, temp);
                used[i] = false;
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
