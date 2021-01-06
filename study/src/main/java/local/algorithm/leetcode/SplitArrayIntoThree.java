package local.algorithm.leetcode;

public class SplitArrayIntoThree {

    public int waysToSplit(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        long count = 0;
        for (int i = 1; i < sums.length - 1; i++) {
            int s1 = sums[i - 1];
            int lowBound = searchLowBound(sums, i, sums.length - 2, s1);
            if (lowBound == -1) {
                continue;
            }
            int highBound = searchHighBound(sums, lowBound, sums.length - 2, s1);
            if (highBound == -1) {
                continue;
            }
            count += highBound - lowBound + 1;
        }
        return (int) (count % (1000000007));
    }

    private int searchLowBound(int[] sums, int start, int end, int s1) {
        int mid, s2, s3;
        while (start <= end) {
            mid = (end + start) / 2;
            s2 = sums[mid] - s1;
            s3 = sums[sums.length - 1] - s2 - s1;
            if (s3 < s2) {
                end = mid - 1;
            } else if (s2 < s1) {
                start = mid + 1;
            } else {
                end = mid;
            }
            if (start == end) {
                break;
            }
        }
        s2 = sums[end] - s1;
        s3 = sums[sums.length - 1] - s2 - s1;
        return (s3 >= s2 && s2 >= s1) ? end : -1;
    }

    private int searchHighBound(int[] sums, int start, int end, int s1) {
        int mid, s2, s3;
        while (start <= end) {
            mid = (end + start) / 2;
            s2 = sums[mid] - s1;
            s3 = sums[sums.length - 1] - s2 - s1;
            if (s3 < s2) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        s2 = sums[start - 1] - s1;
        s3 = sums[sums.length - 1] - s2 - s1;
        return (s3 >= s2 && s2 >= s1) ? start - 1 : -1;
    }

    public int waysToSplitForce(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        long count = 0;
        for (int i = 1; i < sums.length - 1; i++) {
            int s1 = sums[i - 1];
            for (int j = i; j < sums.length - 1; j++) {
                int s2 = sums[j] - sums[i - 1];
                int s3 = sums[sums.length - 1] - sums[j];
                if (s3 >= s2 && s2 >= s1) {
                    count++;
                }
            }
        }
        return (int) (count % (1000000007));
    }
}
