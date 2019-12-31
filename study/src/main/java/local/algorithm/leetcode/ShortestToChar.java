package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class ShortestToChar {

    public int[] shortestToChar(String S, char C) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                indices.add(i);
            }
        }
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != C) {
                result[i] = Math.abs(search(indices, i) - i);
            }
        }
        return result;
    }

    int search(List<Integer> indices, int target) {
        int low = 0, high = indices.size(), pos = low + (high - low) / 2;
        while (low < high) {
            int val = indices.get(pos);
            if (val == target) {
                return 0;
            } else if (val < target) {
                low = pos + 1;
            } else {
                high = pos;
            }
            pos = low + (high - low) / 2;
        }
        if (low <= 0) {
            return indices.get(0);
        } else if (low >= indices.size()) {
            return indices.get(indices.size() - 1);
        }

        int pre = indices.get(low - 1);
        int curr = indices.get(low);
        int post = low + 1 < indices.size() ? indices.get(low + 1) : indices.get(low);

        if (target < curr) {
            if (Math.abs(target - pre) < Math.abs(target - curr)) {
                return pre;
            } else {
                return curr;
            }
        } else {
            if (Math.abs(target - post) < Math.abs(target - curr)) {
                return post;
            } else {
                return curr;
            }
        }
    }
}
