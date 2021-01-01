package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[][] aCount = new int[A.length][26];
        int[][] bCount = new int[B.length][26];
        int[] maxCount = new int[26];
        for (int i = 0; i < A.length; i++) {
            String a = A[i];
            for (int j = 0; j < a.length(); j++) {
                aCount[i][a.charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < B.length; i++) {
            String b = B[i];
            for (int j = 0; j < b.length(); j++) {
                bCount[i][b.charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < bCount.length; i++) {
            for (int j = 0; j < 26; j++) {
                maxCount[j] = Math.max(maxCount[j], bCount[i][j]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < aCount.length; i++) {
            if (contains(aCount[i], maxCount)) {
                result.add(A[i]);
            }
        }
        return result;
    }

    private boolean contains(int[] count, int[] maxCount) {
        for (int i = 0; i < 26; i++) {
            if (count[i] < maxCount[i]) {
                return false;
            }
        }
        return true;
    }

}
