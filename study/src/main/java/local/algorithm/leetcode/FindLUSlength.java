package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class FindLUSlength {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        } else if (a.length() > b.length()) {
            return a.length();
        } else {
            return b.length();
        }
    }
}
