package local.algorithm.leetcode;

import java.util.Arrays;

public class FindBestValue {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sum = 0, minDiff = target, minDiffValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int mostClose = mostClose(sum, target, arr.length - i);
            if (i < arr.length - 1) {
                mostClose = Math.min(mostClose, arr[i + 1]);
            } else {
                mostClose = Math.min(mostClose, arr[arr.length - 1]);
            }
            if (i > 0) {
                mostClose = Math.max(mostClose, arr[i - 1]);
            }
            int currSum = 0;
            if (mostClose <= arr[i]) {
                currSum = sum + mostClose * (arr.length - i);
            } else {
                currSum = sum + arr[i] + mostClose * (arr.length - i - 1);
            }
            int currDiff = Math.abs(target - currSum);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                minDiffValue = mostClose;
            } else if (currDiff == minDiff) {
                minDiffValue = Math.min(minDiffValue, mostClose);
            }
            sum += arr[i];
        }
        return minDiffValue;
    }

    private int mostClose(int sum, int target, int count) {
        int baseVal = Math.abs(target - sum) / count;
        if (Math.abs(target - sum - count * baseVal) <= Math.abs(target - sum - count * (baseVal + 1))) {
            return baseVal;
        } else {
            return baseVal + 1;
        }
    }
}
