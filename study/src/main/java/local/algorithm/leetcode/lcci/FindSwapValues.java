package local.algorithm.leetcode.lcci;

import java.util.HashSet;
import java.util.Set;

public class FindSwapValues {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> set1 = new HashSet<>();
        for (int i : array1) {
            sum1 += i;
            set1.add(i);
        }
        for (int i : array2) {
            sum2 += i;
        }
        if ((sum2 - sum1) % 2 != 0) {
            return new int[0];
        }
        int need = (sum2 - sum1) / 2;
        for (int i : array2) {
            if (set1.contains(i - need)) {
                return new int[]{i - need, i};
            }
        }
        return new int[0];
    }
}
