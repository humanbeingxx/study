package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 21:03
 */
public class SubsequenceInLongString {

    public boolean isSubsequence(String s, String t) {
        List<List<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            indices.add(new ArrayList<>());
        }
        for (int i = 0; i < t.length(); i++) {
            indices.get(t.charAt(i) - 'a').add(i);
        }

        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index = findFirstThanMin(indices.get(c - 'a'), index);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    int findFirstThanMin(List<Integer> indices, int min) {
        int low = 0, high = indices.size(), pos = low + (high - low) / 2;
        while (low < high) {
            if (indices.get(pos) <= min) {
                low = pos + 1;
            } else {
                high = pos;
            }
            pos = low + (high - low) / 2;
        }
        if (low >= indices.size()) {
            return -1;
        }
        return indices.get(low);
    }
}
