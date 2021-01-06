package local.algorithm.leetcode;

import java.util.Arrays;

public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        int[] statePos = new int[32];
        Arrays.fill(statePos, -1);
        int state = 0b00000, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                state = (state ^ 0b00001) & 0b11111;
            } else if (c == 'e') {
                state = (state ^ 0b00010) & 0b11111;
            } else if (c == 'i') {
                state = (state ^ 0b00100) & 0b11111;
            } else if (c == 'o') {
                state = (state ^ 0b01000) & 0b11111;
            } else if (c == 'u') {
                state = (state ^ 0b10000) & 0b11111;
            }
            if (state > 0 && statePos[state] == -1) {
                statePos[state] = i;
            } else {
                maxLen = Math.max(maxLen, i - statePos[state]);
            }
        }
        return maxLen;


//        boolean[][] counts = new boolean[s.length()][5];
//        int maxLen = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (i == 0) {
//                counts[i][0] = c != 'a';
//                counts[i][1] = c != 'e';
//                counts[i][2] = c != 'i';
//                counts[i][3] = c != 'o';
//                counts[i][4] = c != 'u';
//            } else {
//                counts[i][0] = c == 'a' ? !counts[i - 1][0] : counts[i - 1][0];
//                counts[i][1] = c == 'e' ? !counts[i - 1][1] : counts[i - 1][1];
//                counts[i][2] = c == 'i' ? !counts[i - 1][2] : counts[i - 1][2];
//                counts[i][3] = c == 'o' ? !counts[i - 1][3] : counts[i - 1][3];
//                counts[i][4] = c == 'u' ? !counts[i - 1][4] : counts[i - 1][4];
//            }
//            if (counts[i][0] &&
//                    counts[i][1] &&
//                    counts[i][2] &&
//                    counts[i][3] &&
//                    counts[i][4]) {
//                maxLen = Math.max(maxLen, i + 1);
//            } else {
//                for (int j = 0; j <= i; j++) {
//                    if (((counts[i][0] && counts[j][0]) || (!counts[i][0] && !counts[j][0])) &&
//                            ((counts[i][1] && counts[j][1]) || (!counts[i][1] && !counts[j][1])) &&
//                            ((counts[i][2] && counts[j][2]) || (!counts[i][2] && !counts[j][2])) &&
//                            ((counts[i][3] && counts[j][3]) || (!counts[i][3] && !counts[j][3])) &&
//                            ((counts[i][4] && counts[j][4]) || (!counts[i][4] && !counts[j][4]))) {
//                        maxLen = Math.max(maxLen, i - j);
//                        break;
//                    }
//                }
//            }
//        }
//        return maxLen;
    }


}
