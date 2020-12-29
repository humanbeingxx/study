package local.algorithm.leetcode;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        if (rating == null || rating.length < 3) {
            return 0;
        }
        int total = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            total += findBigger(rating[i], rating, 0, i - 1)
                    * findSmaller(rating[i], rating, i+1, rating.length - 1);
            total += findSmaller(rating[i], rating, 0, i - 1)
                    * findBigger(rating[i], rating, i+1, rating.length - 1);
        }
        return total;
    }

    private int findBigger(int val, int[] rating, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (rating[i] > val) {
                count++;
            }
        }
        return count;
    }

    private int findSmaller(int val, int[] rating, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (rating[i] < val) {
                count++;
            }
        }
        return count;
    }
}
