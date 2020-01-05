package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class DIStringMatch {

    public int[] diStringMatch(String S) {
        int small = 0, big = S.length();
        int[] result = new int[S.length() + 1];
        if (S.charAt(0) == 'D') {
            result[0] = big--;
        } else {
            result[0] = small++;
        }
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                result[i] = big--;
            } else {
                result[i] = small++;
            }
        }
        result[S.length()] = small;

        return result;
    }
}
