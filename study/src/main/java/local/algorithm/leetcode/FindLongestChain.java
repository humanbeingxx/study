package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int maxLen = 0, currRight = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > currRight) {
                currRight = pair[1];
                maxLen++;
            }
        }
        return maxLen;
    }
}
