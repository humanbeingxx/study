package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 1:57
 */
public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        char[] diff1 = null;
        char[] diff2 = null;
        int[] counts = new int['a' + 26];
        for (int i = 0; i < A.length(); i++) {
            counts[A.charAt(i)]++;
            if (A.charAt(i) != B.charAt(i)) {
                if (diff1 == null) {
                    diff1 = new char[]{A.charAt(i), B.charAt(i)};
                } else if (diff2 == null) {
                    diff2 = new char[]{A.charAt(i), B.charAt(i)};
                } else {
                    return false;
                }
            }
        }
        if (diff1 == null) {
            for (int count : counts) {
                if (count > 1) {
                    return true;
                }
            }
            return false;
        }

        return diff2 != null && diff1[0] == diff2[1] && diff1[1] == diff2[0];
    }
}
