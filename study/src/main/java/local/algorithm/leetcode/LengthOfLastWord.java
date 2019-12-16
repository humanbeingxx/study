package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        boolean reachWord = false;
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (!reachWord) {
                    continue;
                } else {
                    break;
                }
            }
            reachWord = true;
            len++;
        }
        return len;
    }
}
