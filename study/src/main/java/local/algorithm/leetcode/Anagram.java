package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:22
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        int[] sc = new int[26];
        int[] tc = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sc[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tc[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sc[i] != tc[i]) {
                return false;
            }
        }
        return true;
    }
}
