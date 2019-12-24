package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String S) {
        if (S.length() == 0) {
            return new ArrayList<>();
        }
        int currLen = 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currResult = new ArrayList<>();
        int i = 0, j = 1;
        for (; j < S.length(); j++) {
            if (S.charAt(j) != S.charAt(i)) {
                if (currLen >= 3) {
                    currResult.add(i);
                    currResult.add(j - 1);
                    result.add(currResult);
                    currResult = new ArrayList<>();
                }
                i = j;
                currLen = 1;
            } else {
                currLen++;
            }
        }
        if (currLen >= 3) {
            currResult.add(i);
            currResult.add(j - 1);
            result.add(currResult);
        }

        return result;
    }
}
