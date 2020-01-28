package local.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class ReorganizeString {

    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }
        int maxLen = S.length() % 2 == 0 ? S.length() / 2 : (S.length() / 2 + 1);
        for (int i : count) {
            if (i > maxLen) {
                return "";
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                queue.add(new int[]{i + 'a', count[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        char curr = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (curr == 0 || curr != poll[0]) {
                curr = (char) poll[0];
                sb.append(curr);
                poll[1]--;
                if (poll[1] > 0) {
                    queue.add(poll);
                }
            } else {
                int[] next = queue.poll();
                curr = (char) next[0];
                sb.append(curr);
                next[1]--;
                queue.add(poll);
                if (next[1] > 0) {
                    queue.add(next);
                }
            }
        }
        return sb.toString();
    }
}
