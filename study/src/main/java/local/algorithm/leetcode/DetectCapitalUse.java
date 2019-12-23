package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class DetectCapitalUse {

    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        int lowerCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < 'a') {
                upperCount++;
                if (lowerCount > 0) {
                    return false;
                }
            } else {
                lowerCount++;
                if (upperCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
