package local.algorithm.leetcode;

public class NumberOfSubstringsABC {

    public int numberOfSubstrings(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }
        int count = 0, start = 0;
        int[] abcCount = new int[3];
        abcCount[s.charAt(0) - 'a']++;
        abcCount[s.charAt(1) - 'a']++;
        for (int i = 2; i < s.length(); i++) {
            abcCount[s.charAt(i) - 'a']++;
            while (abcCount[0] > 0 && abcCount[1] > 0 && abcCount[2] > 0) {
                count += s.length() - i;
                abcCount[s.charAt(start) - 'a']--;
                start++;
            }
        }
        return count;
    }
}
