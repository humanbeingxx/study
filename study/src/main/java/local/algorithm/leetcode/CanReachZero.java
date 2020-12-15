package local.algorithm.leetcode;

public class CanReachZero {

    private static final int MAX = 50000;

    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        boolean[] reached = new boolean[MAX];
        return rec(arr, start, reached);
    }

    private boolean rec(int[] arr, int start, boolean[] reached) {
        if (start < 0 || start >= arr.length || reached[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        reached[start] = true;
        return rec(arr, start + arr[start], reached) || rec(arr, start - arr[start], reached);
    }
}
