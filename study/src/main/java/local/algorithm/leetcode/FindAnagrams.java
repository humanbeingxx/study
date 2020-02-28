package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return result;
        }
        int[] sCounter = new int[26];
        int[] pCounter = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCounter[s.charAt(i) - 'a']++;
            pCounter[p.charAt(i) - 'a']++;
        }
        int index = 0;
        if (sameCounter(sCounter, pCounter)) {
            result.add(index);
        }
        for (index++; index <= sLen - pLen; index++) {
            sCounter[s.charAt(index - 1) - 'a']--;
            sCounter[s.charAt(index + pLen - 1) - 'a']++;
            if (sameCounter(sCounter, pCounter)) {
                result.add(index);
            }
        }
        return result;
    }

    private boolean sameCounter(int[] sCounter, int[] pCounter) {
        for (int i = 0; i < sCounter.length; i++) {
            if (sCounter[i] != pCounter[i]) {
                return false;
            }
        }
        return true;
    }
}
