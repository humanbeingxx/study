package local.algorithm.leetcode;

public class NumEquivDominoPairs20210126 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] counts = new int[10][10];
        for (int[] card : dominoes) {
            if (card[0] <= card[1]) {
                counts[card[0]][card[1]]++;
            } else {
                counts[card[1]][card[0]]++;
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result += counts[i][j] * (counts[i][j] - 1) / 2;
            }
        }
        return result;
    }
}
