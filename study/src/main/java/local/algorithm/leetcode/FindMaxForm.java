package local.algorithm.leetcode;

public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] forms = new int[m + 1][n + 1];
        for (String str : strs) {
            int count0 = 0, count1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }

            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    forms[i][j] = Math.max(forms[i][j], forms[i-count0][j-count1] + 1);
                }
            }
        }
        return forms[m][n];
    }
}
