package local.algorithm.leetcode;

public class NumDecodings {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] counts = new int[s.length()];
        counts[counts.length - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                counts[i] = 0;
            } else {
                if (checkAfter(s, i)) {
                    counts[i] = counts[i + 1] + (i == s.length() - 2 ? 1 : counts[i + 2]);
                } else {
                    counts[i] = counts[i + 1];
                }
            }
        }
        return counts[0];
    }

    private boolean checkAfter(String s, int curr) {
        if (s.charAt(curr) == '1') {
            return true;
        } else {
            return s.charAt(curr) == '2' && s.charAt(curr + 1) <= '6';
        }
    }
}
