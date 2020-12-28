package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SplitIntoFibonacci {

    public List<Integer> splitIntoFibonacci(String S) {
        if (S.length() < 3) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        long first = 0;
        boolean firstIs0 = S.charAt(0) == '0';
        for (int i = 0; i < S.length() - 1; i++) {
            long second = 0;
            char ci = S.charAt(i);
            if (ci != '0' && firstIs0) {
                break;
            }
            first = first * 10 + ci - '0';
            if (first > Integer.MAX_VALUE) {
                break;
            }
            result.add((int) first);
            boolean secondIs0 = S.charAt(i + 1) == '0';
            for (int j = i + 1; j < S.length(); j++) {
                char cj = S.charAt(j);
                if (cj != '0' && secondIs0) {
                    break;
                }
                second = second * 10 + cj - '0';
                if (second > Integer.MAX_VALUE) {
                    break;
                }
                result.add((int) second);
                if (checkRec(S, j + 1, result)) {
                    return result;
                }
                result.clear();
                result.add((int) first);
            }
            result.clear();
        }
        return result;
    }

    private boolean checkRec(String s, int index, List<Integer> result) {
        if (index == s.length()) {
            return result.size() > 2;
        }
        long first = result.get(result.size() - 2);
        long second = result.get(result.size() - 1);
        long val = 0, sum = first + second;
        if (s.charAt(index) == '0') {
            if (sum != 0) {
                return false;
            }
            result.add(0);
            while (index < s.length()) {
                if (s.charAt(index) != '0') {
                    return false;
                }
                index++;
            }
            return true;
        }
        for (int i = index; i < s.length(); i++) {
            val = val * 10 + s.charAt(i) - '0';
            if (val > Integer.MAX_VALUE || val > sum) {
                return false;
            } else if (val == sum) {
                result.add((int) val);
                return checkRec(s, i + 1, result);
            }
        }
        return false;
    }
}
