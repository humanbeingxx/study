package local.algorithm.leetcode;

public class NumOfSubarraysWithThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int thresholdSum = k * threshold, currSum = 0, count = 0;
        int index = k;
        for (int i = 0; i < index; i++) {
            currSum += arr[i];
        }
        if (currSum >= thresholdSum) {
            count++;
        }
        for (; index < arr.length; index++) {
            currSum += arr[index];
            currSum -= arr[index - k];
            if (currSum >= thresholdSum) {
                count++;
            }
        }
        return count;
    }
}
