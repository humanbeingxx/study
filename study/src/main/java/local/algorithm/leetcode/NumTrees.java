package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-11
 **/
public class NumTrees {

    public int numTrees(int n) {
        int count = 0;
        int[][][] checked = new int[n + 1][n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            count += rec(1, n, i, checked);
        }
        return count;
    }

    private int rec(int from, int to, int root, int[][][] checked) {
        if (from == to) {
            return 1;
        }
        //left
        int left = 0;
        if (root == from || root == from + 1) {
            left = 1;
        } else {
            for (int i = from; i <= root - 1; i++) {
                if (checked[from][root - 1][i] > 0) {
                    left += checked[from][root - 1][i];
                } else {
                    int newLeft = rec(from, root - 1, i, checked);
                    left += newLeft;
                    checked[from][root - 1][i] = newLeft;
                }
            }
        }

        //right
        int right = 0;
        if (root == to || root == to + 1) {
            right = 1;
        } else {
            for (int i = root + 1; i <= to; i++) {
                if (checked[root + 1][to][i] > 0) {
                    right += checked[root + 1][to][i];
                } else {
                    int newRight = rec(root + 1, to, i, checked);
                    right += newRight;
                    checked[root + 1][to][i] = newRight;
                }
            }
        }

        return left * right;
    }
}
