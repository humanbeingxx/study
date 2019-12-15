package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 15:30
 */
public class MinDiff {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        return simple(arr);
    }

    private List<List<Integer>> simple(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int diff = Math.abs(arr[i] - arr[j]);
            if (diff <= min) {
                if (diff < min) {
                    result.clear();
                }
                min = diff;
                ArrayList<Integer> oneResult = new ArrayList<>();
                oneResult.add(arr[i]);
                oneResult.add(arr[j]);
                result.add(oneResult);
            }
        }
        return result;
    }
}
