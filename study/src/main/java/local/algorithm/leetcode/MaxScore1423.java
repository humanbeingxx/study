package local.algorithm.leetcode;

public class MaxScore1423 {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int i = k - 1; i >= 0; i--) {
            sum += (cardPoints[cardPoints.length + i - k] - cardPoints[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
