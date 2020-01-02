package local.algorithm.leetcode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] result = new int[arr1.length];
        for (int i : arr1) {
            bucket[i]++;
        }

        int index = 0;
        for (int i : arr2) {
            while (bucket[i] > 0) {
                result[index++] = i;
                bucket[i]--;
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                result[index++] = i;
                bucket[i]--;
            }
        }
        return result;
    }
}
