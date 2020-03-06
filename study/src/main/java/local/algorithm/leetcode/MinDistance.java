package local.algorithm.leetcode;

public class MinDistance {

    public int minDistance(String word1, String word2) {
        int lcsLen = lcs(word1, word2);
        return word1.length() + word2.length() - 2 * lcsLen;
    }

    int lcs(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return 0;
        }
        int[][] checked = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);

                if (c1 != c2) {
                    checked[i][j] = Math.max(checked[i - 1][j], checked[i][j - 1]);
                } else {
                    checked[i][j] = checked[i - 1][j - 1] + 1;
                }
            }
        }
        return checked[word1.length()][word2.length()];
    }
}
