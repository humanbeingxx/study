package local.algorithm.leetcode;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() ==0) {
            return 0;
        }
        int[][] lens = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    lens[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lens[i][j] = lens[i - 1][j - 1] + 1;
                } else {
                    lens[i][j] = Math.max(lens[i - 1][j], lens[i][j - 1]);
                }
            }
        }
        return lens[text1.length()][text2.length()];
    }
}
