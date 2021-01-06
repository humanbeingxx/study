package local.algorithm.leetcode.lcof;

public class MovingCount {

    public int movingCount(int m, int n, int k) {
        boolean[][] counted = new boolean[m][n];
        return rec(0, 0, m, n, k, counted);
    }

    private int rec(int i, int j, int m, int n, int k, boolean[][] counted) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return 0;
        }
        if (counted[i][j]) {
            return 0;
        }
        counted[i][j] = true;
        if (overK(i, j, k)) {
            return 0;
        }
        return 1 + rec(i - 1, j, m, n, k, counted)
                + rec(i + 1, j, m, n, k, counted)
                + rec(i, j - 1, m, n, k, counted)
                + rec(i, j + 1, m, n, k, counted);
    }

    private boolean overK(int i, int j, int k) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum > k;
    }
}
