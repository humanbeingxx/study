package local.algorithm.leetcode;

public class MaxVowelsInSub {

    public int maxVowels(String s, int k) {
        int max = 0, currentCount = 0, index = 0, currentLen = 0;
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            if (currentLen < k) {
                if (isVowel(currentChar)) {
                    currentCount++;
                }
                currentLen++;
            } else {
                if (isVowel(currentChar)) {
                    currentCount++;
                }
                if (isVowel(s.charAt(index - k))) {
                    currentCount--;
                }
            }
            max = Math.max(max, currentCount);
            index++;
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
    }
}
