package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] saw = new int[256];
        int maxLen = 0, currLen = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (saw[c] > 0) {
                currLen = clear(saw, c) + 1;
                saw[c] = i + 1;
            } else {
                saw[c] = i + 1;
                currLen++;
                if (currLen > maxLen) {
                    maxLen = currLen;
                }
            }
        }
        return maxLen;
    }

    private int clear(int[] saw, char c) {
        int count = 0;
        int sawC = saw[c];
        for (int i = 0, len = saw.length; i < len; i++) {
            if (saw[i] <= sawC) {
                saw[i] = 0;
            } else if (saw[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
