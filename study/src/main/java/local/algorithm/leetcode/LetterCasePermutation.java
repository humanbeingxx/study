package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        rec(S, 0, result);
        return result;
    }

    private void rec(String s, int index, List<String> result) {
        if (index == s.length()) {
            return;
        }
        char c = s.charAt(index);
        if (c >= 'a' && c <= 'z') {
            String newS;
            if (index == 0) {
                newS = (char) (s.charAt(index) - ('a' - 'A')) + s.substring(index + 1);
            } else if (index == s.length() - 1) {
                newS = s.substring(0, s.length() - 1) + (char) (s.charAt(index) - ('a' - 'A'));
            } else {
                newS = s.substring(0, index) + (char) (s.charAt(index) - ('a' - 'A')) + s.substring(index + 1);
            }
            result.add(newS);
            rec(newS, index + 1, result);
        } else if (c >= 'A' && c <= 'Z') {
            String newS;
            if (index == 0) {
                newS = (char) (s.charAt(index) + ('a' - 'A')) + s.substring(index + 1);
            } else if (index == s.length() - 1) {
                newS = s.substring(0, s.length() - 1) + (char) (s.charAt(index) + ('a' - 'A'));
            } else {
                newS = s.substring(0, index) + (char) (s.charAt(index) + ('a' - 'A')) + s.substring(index + 1);
            }
            result.add(newS);
            rec(newS, index + 1, result);
        }
        rec(s, index + 1, result);
    }
}
