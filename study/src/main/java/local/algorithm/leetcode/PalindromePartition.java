package local.algorithm.leetcode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-23
 **/
public class PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> collector = new ArrayList<>();
        int[][] checked = new int[s.length()][s.length()];
        partitionRec(s, 0, collector, result, checked);
        return result;
    }

    private void partitionRec(String s, int start, List<String> collector, List<List<String>> result, int[][] checked) {
        if (start == s.length()) {
            result.add(new ArrayList<>(collector));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (check(s, start, i, checked)) {
                collector.add(s.substring(start, i + 1));
                partitionRec(s, i + 1, collector, result, checked);
                collector.remove(collector.size() - 1);
            }
        }
    }

    private boolean check(String s, int start, int end, int[][] checked) {
        if (end >= s.length()) {
            return false;
        }

        if (end == start) {
            checked[start][end] = 1;
            return true;
        }

        if (checked[start][end] != 0) {
            return checked[start][end] == 1;
        }
        int pEnd, pStart;
        if ((end - start) % 2 == 0) {
            pEnd = start + (end - start) / 2 - 1;
            pStart = start + (end - start) / 2 + 1;
        } else {
            pEnd = start + (end - start) / 2;
            pStart = start + (end - start) /2 + 1;
        }
        for (; pEnd >= start; pEnd--, pStart++) {
            if (s.charAt(pEnd) != s.charAt(pStart)) {
                checked[start][end] = -1;
                return false;
            }
        }
        checked[start][end] = 1;
        return true;
    }
}
