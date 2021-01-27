package local.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        rec(chars, new StringBuilder(), result, used);
        return result;
    }

    private void rec(char[] chars, StringBuilder temp, ArrayList<String> result, boolean[] used) {
        if (temp.length() == chars.length) {
            result.add(temp.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                temp.append(chars[i]);
                rec(chars, temp, result, used);
                temp.deleteCharAt(temp.length() - 1);
                used[i] = false;
            }
        }
    }
}
