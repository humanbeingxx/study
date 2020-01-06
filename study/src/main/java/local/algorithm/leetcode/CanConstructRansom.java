package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class CanConstructRansom {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            mCount[magazine.charAt(i) - 'a']++;
        }

        int[] rCount = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            rCount[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (mCount[i] < rCount[i]) {
                return false;
            }
        }
        return true;
    }
}
