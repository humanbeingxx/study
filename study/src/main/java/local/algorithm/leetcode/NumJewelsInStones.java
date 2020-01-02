package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 21:42
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        int[] js = new int[256];
        for (int i = 0; i < J.length(); i++) {
            js[J.charAt(i)] = 1;
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (js[S.charAt(i)] > 0) {
                count++;
            }
        }
        return count;
    }
}
