package local.algorithm.leetcode.lcci;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/19 17:09
 */
public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null) {
            return true;
        } else if (first == null || second == null) {
            return false;
        }
        int len1 = first.length(), len2 = second.length();
        if (len1 != len2 && Math.abs(len1 - len2) != 1) {
            return false;
        }
        int index1 = 0, index2 = 0;
        boolean modified = false;
        while (index1 < len1 && index2 < len2) {
            char c1 = first.charAt(index1);
            char c2 = second.charAt(index2);
            if (c1 == c2) {
                index1++;
                index2++;
            } else {
                if (modified) {
                    return false;
                } else {
                    modified = true;
                }
                if (len1 == len2) {
                    index1++;
                    index2++;
                } else if (len1 > len2) {
                    index1++;
                } else {
                    index2++;
                }
            }
        }
        return (index1 == len1 && index2 == len2) || (!modified && index1 == len1 && index2 == len2 - 1) || (!modified && index1 == len1 - 1 && index2 == len2);
    }

}
