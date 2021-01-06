package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-23
 **/
public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] out = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            if (left >= 0) {
                in[left]++;
                out[i]++;
            }
            if (right >= 0) {
                in[right]++;
                out[i]++;
            }
        }
        boolean rootFound = false;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                if (rootFound) {
                    return false;
                } else {
                    rootFound = true;
                }
            } else if (in[i] > 1) {
                return false;
            }
            if (out[i] > 2) {
                return false;
            }
        }
        return rootFound;
    }
}
