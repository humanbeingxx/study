package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 21:48
 */
public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        char[] mapping = new char[256];
        boolean[] used = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (mapping[a] == 0) {
                if (used[b]) {
                    return false;
                }
                mapping[a] = b;
                used[b] = true;
            } else if (mapping[a] != b) {
                return false;
            }
        }
        return true;
    }
}
