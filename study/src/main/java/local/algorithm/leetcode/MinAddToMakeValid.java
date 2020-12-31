package local.algorithm.leetcode;

public class MinAddToMakeValid {

    public int minAddToMakeValid(String S) {
        int invalid = 0;
        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                left++;
            } else {
                if (left == 0) {
                    invalid++;
                } else {
                    left--;
                }
            }
        }
        invalid += left;
        return invalid;
    }
}
