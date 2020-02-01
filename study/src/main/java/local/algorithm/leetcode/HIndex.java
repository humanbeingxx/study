package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-01
 **/
public class HIndex {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int paperCount = 0;
        for (int ref = citations[citations.length - 1], index = citations.length - 1; index >= 0 && ref >= 0;) {
            if (ref <= paperCount) {
                return paperCount;
            }
            if (ref == citations[index]) {
                index--;
                paperCount++;
            } else {
                ref--;
            }
        }
        return paperCount;
    }
}
