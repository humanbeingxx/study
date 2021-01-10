package local.algorithm.leetcode;

public class ConstructDistancedSequence {

    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        rec(0, result, used, n);
        return result;
    }

    private boolean rec(int index, int[] result, boolean[] used, int max) {
        if (index >= result.length) {
            return true;
        }
        if (result[index] != 0) {
            return rec(index + 1, result, used, max);
        }
        for (int i = max; i >= 2; i--) {
            if (used[i] || index + i >= result.length || result[index + i] != 0) {
                continue;
            }
            used[i] = true;
            result[index] = i;
            result[index + i] = i;
            if (rec(index + 1, result, used, max)) {
                return true;
            }
            result[index] = 0;
            result[index + i] = 0;
            used[i] = false;
        }
        if (!used[1]) {
            used[1] = true;
            result[index] = 1;
            if (rec(index + 1, result, used, max)) {
                return true;
            }
            result[index] = 0;
            used[1] = false;
        }
        return false;
    }
}
