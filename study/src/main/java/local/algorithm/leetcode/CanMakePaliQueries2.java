package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CanMakePaliQueries2 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            result.add(checkPal(s, query));
        }
        return result;
    }

    private Boolean checkPal(String s, int[] query) {
        int start = query[0], end = query[1], k = query[2];
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (k == 0) {
                    return false;
                }
                k--;
            }
            start++;
            end--;
        }
        return true;
    }
}
