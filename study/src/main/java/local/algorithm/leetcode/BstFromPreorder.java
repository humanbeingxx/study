package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class BstFromPreorder {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildRec(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildRec(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = preorder[start];
        TreeNode node = new TreeNode(val);
        int lessIndex = start + 1;
        while (lessIndex <= end && preorder[lessIndex] < val) {
            lessIndex++;
        }
        node.left = buildRec(preorder, start + 1, lessIndex - 1);
        node.right = buildRec(preorder, lessIndex, end);
        return node;
    }
}
