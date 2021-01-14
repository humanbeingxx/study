package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class PseudoPalindromicPaths {

    int count = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] counts = new int[10];
        rec(root, counts);
        return count;
    }

    private void rec(TreeNode node, int[] counts) {
        if (node == null) {
            return;
        }
        counts[node.val]++;
        if (node.left != null) {
            rec(node.left, counts);
        }
        if (node.right != null) {
            rec(node.right, counts);
        }
        if (node.left == null && node.right == null) {
            if (checkCounts(counts)) {
                count++;
            }
        }
        counts[node.val]--;
    }

    private boolean checkCounts(int[] counts) {
        int odd = 0;
        for (int count : counts) {
            if (count % 2 != 0) {
                odd++;
            }
            if (odd >= 2) {
                return false;
            }
        }
        return true;
    }
}
