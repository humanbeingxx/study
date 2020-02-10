package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class MinSetSize {

    public int minSetSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] counts = new int[100001];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        Arrays.sort(counts);
        int len = arr.length, sum = 0, count = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == 0) {
                continue;
            }
            sum += counts[i];
            count++;
            if (sum >= len / 2) {
                break;
            }

        }
        return count;
    }
}
