package local.algorithm.leetcode;

public class FindPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0 || timeSeries.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] < timeSeries[i] + duration) {
                total += timeSeries[i + 1] - timeSeries[i];
            } else {
                total += duration;
            }
        }
        total += duration;
        return total;
    }
}
