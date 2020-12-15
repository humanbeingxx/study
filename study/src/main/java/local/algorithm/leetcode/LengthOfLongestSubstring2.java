package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class LengthOfLongestSubstring2 {

    public int lengthOfLongestSubstring(String s) {
        int[] saw = new int[256];
        Arrays.fill(saw, -1);
        int maxLen = 0, currLen = 0, leftBoundary = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (saw[c] == -1) {
                saw[c] = i;
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                if (saw[c] >= leftBoundary) {
                    leftBoundary = saw[c] + 1;
                }
                currLen = i - leftBoundary + 1;
                maxLen = Math.max(maxLen, currLen);
                saw[c] = i;
            }
        }
        return maxLen;
    }

}
