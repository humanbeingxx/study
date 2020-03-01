package local.algorithm.leetcode;

import java.util.Arrays;

public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if (checkCount(count1, count2)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            char c = s2.charAt(i);
            char preC = s2.charAt(i - s1.length());
            count2[c - 'a']++;
            count2[preC - 'a']--;
            if (checkCount(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCount(int[] count1, int[] count2) {
        return Arrays.equals(count1, count2);
    }
}
