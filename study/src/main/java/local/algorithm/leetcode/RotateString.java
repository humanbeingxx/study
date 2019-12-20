package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class RotateString {

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
