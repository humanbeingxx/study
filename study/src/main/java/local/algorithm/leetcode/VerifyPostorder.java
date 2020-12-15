package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/5 15:38
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return verifySub(postorder, 0, postorder.length - 1);
    }

    private boolean verifySub(int[] postorder, int from, int to) {
        if (from >= to) {
            return true;
        }
        int root = postorder[to];
        int splitIndex = to;
        for (int i = from; i < to - 1; i++) {
            if (postorder[i] > root) {
                splitIndex = i;
                break;
            }
        }
        for (int i = splitIndex + 1; i <= to - 1; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return verifySub(postorder, from, splitIndex - 1) && verifySub(postorder, splitIndex, to - 1);
    }
}
