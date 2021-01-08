package local.algorithm.leetcode;

public class StoneGameVII {

    public int stoneGameVII(int[] stones) {
        Integer[][] scores = new Integer[stones.length][stones.length];
        int[] sums = new int[stones.length];
        sums[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            sums[i] = sums[i - 1] + stones[i];
        }
        playRec(stones, 0, stones.length - 1, scores, sums);
        return scores[0][stones.length - 1];
    }

    private void playRec(int[] stones, int i, int j, Integer[][] scores, int[] sums) {
        if (i < 0 || i >= stones.length || j < 0 || j >= stones.length || scores[i][j] != null) {
            return;
        }
        if (i == j) {
            scores[i][i] = 0;
        } else if (i == j - 1) {
            scores[i][j] = Math.max(stones[i], stones[j]);
        } else {
            playRec(stones, i + 1, j, scores, sums);
            playRec(stones, i, j - 1, scores, sums);
            scores[i][j] = Math.max(sums[j] - sums[i] - scores[i + 1][j],
                    sums[j - 1] - (i == 0 ? 0 : sums[i - 1]) - scores[i][j - 1]);
        }
    }

    public int stoneGameVIIByDp(int[] stones) {
        int[][] scores = new int[stones.length][stones.length];
        int[] sums = new int[stones.length];
        sums[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            sums[i] = sums[i - 1] + stones[i];
        }
        for (int i = stones.length - 1; i >= 0; i--) {
            scores[i][i + 1] = Math.max(stones[i], stones[i + 1]);
            for (int j = i + 2; j < stones.length; j++) {
                scores[i][j] = Math.max(sums[j] - sums[i] - scores[i + 1][j],
                        sums[j - 1] - (i == 0 ? 0 : sums[i - 1]) - scores[i][j - 1]);
            }
        }
        return scores[0][stones.length - 1];
    }
}
