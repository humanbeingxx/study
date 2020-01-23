package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-23
 **/
public class PalindromeSubString {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += check(s, i);
        }
        return count;
    }

    private int check(String s, int center) {
        int count = 1;

        //contain center
        count += count(s, center - 1, center + 1);
        //not contain center;
        count += count(s, center - 1, center);

        return count;
    }

    private int count(String s, int preEnd, int nextBegin) {
        int count = 0;
        for (; preEnd >= 0 && nextBegin < s.length(); preEnd--, nextBegin++) {
            if (s.charAt(preEnd) == s.charAt(nextBegin)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
