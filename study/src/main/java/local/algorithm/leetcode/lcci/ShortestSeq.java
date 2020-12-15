package local.algorithm.leetcode.lcci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestSeq {

    public int[] shortestSeq(int[] big, int[] small) {
        if (big == null || big.length < small.length) {
            return new int[0];
        }
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> smallSet = new HashSet<>();
        for (int i : small) {
            smallSet.add(i);
        }
        int start = -1, end = 0, minStart = -1, minEnd = -1, minLen = big.length + 1, matchLen = 0;
        while (end < big.length) {
            if (!smallSet.contains(big[end])) {
                end++;
                continue;
            }

            if (start == -1) {
                do {
                    start++;
                } while (start < end && !smallSet.contains(big[start]));
            }
            if (!count.containsKey(big[end])) {
                count.put(big[end], 1);
                matchLen++;
            } else {
                count.put(big[end], count.get(big[end]) + 1);
                while (start < end) {
                    if (count.containsKey(big[start])) {
                        if (count.get(big[start]) > 1) {
                            count.put(big[start], count.get(big[start]) - 1);
                        } else {
                            break;
                        }
                    }
                    start++;
                }
            }
            if (matchLen == small.length) {
                int currLen = end - start + 1;
                if (currLen < minLen) {
                    minStart = start;
                    minEnd = end;
                    minLen = currLen;
                }
            }
            end++;
        }
        if (minStart >= 0 && minEnd >= 0 && matchLen == small.length) {
            return new int[]{minStart, minEnd};
        } else {
            return new int[0];
        }
    }
}


