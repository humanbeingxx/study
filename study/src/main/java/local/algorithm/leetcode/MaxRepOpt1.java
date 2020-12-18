package local.algorithm.leetcode;

public class MaxRepOpt1 {

    public int maxRepOpt1(String text) {
        int maxLen = 0, currLen = 1;
        char lastChar = text.charAt(0);
        int[] counts = new int[26];
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
        }
        for (int i = 1; i < text.length(); i++) {
            char currChar = text.charAt(i);
            if (currChar == lastChar) {
                currLen++;
                maxLen = Math.max(currLen, maxLen);
            } else {
                int index = i + 1;
                while (index < text.length() && text.charAt(index) == lastChar) {
                    index++;
                    currLen++;
                }
                if (counts[lastChar - 'a'] > currLen) {
                    currLen++;
                }
                maxLen = Math.max(currLen, maxLen);
                currLen = 1;
                lastChar = currChar;
            }
        }
        if (currLen > 1 && counts[lastChar - 'a'] > currLen) {
            maxLen = Math.max(maxLen, currLen + 1);
        }
        return maxLen;
    }
}
