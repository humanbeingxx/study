package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation2 {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null || S.isEmpty()) {
            return result;
        }
        StringBuilder tempResult = new StringBuilder();
        permutateRec(0, S, tempResult, result);
        return result;
    }

    private void permutateRec(int index, String source, StringBuilder tempResult, List<String> result) {
        if (index == source.length()) {
            result.add(tempResult.toString());
            return;
        }
        char c = source.charAt(index);
        tempResult.append(c);
        permutateRec(index + 1, source, tempResult, result);
        tempResult.deleteCharAt(tempResult.length() - 1);

        if (isAlpha(c)) {
            char changeCase = changeCase(c);
            tempResult.append(changeCase);
            permutateRec(index + 1, source, tempResult, result);
            tempResult.deleteCharAt(tempResult.length() - 1);
        }
    }

    private boolean isAlpha(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    private char changeCase(char c) {
        if ('a' <= c && c <= 'z') {
            return (char) (c - 'a' + 'A');
        } else {
            return (char) (c - 'A' + 'a');
        }
    }
}
