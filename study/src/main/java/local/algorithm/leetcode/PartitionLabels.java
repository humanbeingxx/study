package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] pos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            pos[S.charAt(i) - 'a'] = i;
        }
        int index = 0;
        List<Integer> result = new ArrayList<>();
        while (index < S.length()) {
            int lastIndex = pos[S.charAt(index) - 'a'];
            for (int i = index + 1; i < lastIndex; i++) {
                char c = S.charAt(i);
                int otherLast = pos[c - 'a'];
                if (otherLast > lastIndex) {
                    lastIndex = otherLast;
                }
            }
            result.add(lastIndex - index + 1);
            index = lastIndex + 1;
        }
        return result;
    }
}
