package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 20:47
 */
public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        int times = (int)Math.ceil((double)B.length() / A.length()) + 1;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < times; i++) {
            sb.append(A);
            if (sb.indexOf(B) >= 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
