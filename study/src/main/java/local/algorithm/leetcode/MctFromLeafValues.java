package local.algorithm.leetcode;

public class MctFromLeafValues {

    int sum = 0;

    public int mctFromLeafValues(int[] arr) {
        rec(arr, 0, arr.length - 1);
        return sum;
    }

    private int rec(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int max = 0, maxIndex = -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if (maxIndex == start) {
            int maxInRight = rec(arr, start + 1, end);
            sum += max * maxInRight;
        } else if (maxIndex == end) {
            int maxInLeft = rec(arr, start, end - 1);
            sum += max * maxInLeft;
        } else {
            int maxInRight = rec(arr, maxIndex + 1, end);
            sum += max * maxInRight;
            int maxInLeft = rec(arr, start, maxIndex - 1);
            sum += max * maxInLeft;
        }
        return max;
    }
}
