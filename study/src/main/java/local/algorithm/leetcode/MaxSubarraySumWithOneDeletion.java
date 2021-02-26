package local.algorithm.leetcode;

public class MaxSubarraySumWithOneDeletion {

    public int maximumSum(int[] arr) {
        int[][] sums = new int[arr.length][2];
        sums[0][0] = Math.max(0, arr[0]);
        sums[0][1] = 0;
        int max = Math.max(sums[0][0], sums[0][1]);
        for (int i = 1; i < arr.length; i++) {
            sums[i][0] = Math.max(arr[i], arr[i] + sums[i-1][0]);
            max = Math.max(max, sums[i][0]);
            sums[i][1] = Math.max(Math.max(arr[i], arr[i] + sums[i-1][1]), sums[i-1][0]);
            max = Math.max(max, sums[i][1]);
        }
        return max;
    }
}
