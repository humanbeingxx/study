package local.algorithm.leetcode;

import java.util.Arrays;

public class MinDeletions1647 {

    public int minDeletions(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        Arrays.sort(counts);
        int pre = -1, deletion = 0;
        for (int i = counts.length - 1; i >= 0 && counts[i] > 0; i--) {
            int count = counts[i];
            if (pre == -1) {
                pre = count;
            } else if (count >= pre) {
                pre = Math.max(pre - 1, 0);
                deletion += (count - pre);
            } else {
                pre = count;
            }
        }
        return deletion;
    }
}
