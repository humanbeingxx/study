package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-12
 **/
public class CharFrequencySort {

    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int[][] counts = new int[256][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int[] count = counts[c];
            if (count[1] == 0) {
                count[0] = c;
                count[1] = 1;
            } else {
                count[1]++;
            }
        }
        Arrays.sort(counts, (o1, o2) -> o2[1] - o1[1]);

        StringBuilder sb = new StringBuilder();

        for (int[] count : counts) {
            if (count[1] == 0) {
                break;
            }
            char c = (char) count[0];
            for (int j = 0; j < count[1]; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
