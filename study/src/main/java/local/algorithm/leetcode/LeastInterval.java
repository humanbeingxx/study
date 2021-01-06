package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-15
 **/
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        Arrays.sort(counts);
        int time = 0;
        while (true) {
            boolean left = false;
            for (int i = 0; i <= n; i++) {
                if (i < counts.length) {
                    if (counts[counts.length - i - 1] == 0 && !left) {
                        return time;
                    }
                    if (counts[counts.length - i - 1] > 0) {
                        counts[counts.length - i - 1]--;
                    }
                    if (counts[counts.length - i - 1] > 0) {
                        left = true;
                    }
                }
                time++;
            }
            Arrays.sort(counts);
            if (counts[25] == 0) {
                return time;
            }
        }
    }

}
