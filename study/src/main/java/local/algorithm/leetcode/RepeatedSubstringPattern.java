package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        String doubleS = s + s;
        return doubleS.substring(1, doubleS.length() - 1).contains(s);
    }
}
`