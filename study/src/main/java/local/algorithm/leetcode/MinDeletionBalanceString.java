package local.algorithm.leetcode;

public class MinDeletionBalanceString {

    public int minimumDeletions(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                countA++;
            }
        }
        if (countA == 0 || countA == s.length()) {
            return 0;
        }
        int passB = 0, min = countA;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                countA--;
            } else {
                passB++;
            }
            int delete = passB + countA;
            min = Math.min(min, delete);
        }
        return min;
    }
}
