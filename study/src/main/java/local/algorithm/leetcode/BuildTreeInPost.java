package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-24
 **/
public class BuildTreeInPost {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart >= postorder.length || postEnd >= postorder.length || postStart < 0 || postEnd < 0) {
            return null;
        }
        if (inStart >= inorder.length || inEnd >= inorder.length || inStart < 0 || inEnd < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int[][] split = splitInOrder(inorder, root.val, inStart, inEnd);
        int[] inLeft = split[0];
        int[] inRight = split[1];
        int preLeftLen = inLeft[1] - inLeft[0] + 1;
        int[] postLeft = new int[]{postStart, postStart + preLeftLen - 1};
        int[] postRight = new int[]{postStart + preLeftLen, postEnd - 1};
        if (postLeft[0] <= postLeft[1] && inLeft[0] <= inLeft[1]) {
            root.left = buildTree(postorder, postLeft[0], postLeft[1], inorder, inLeft[0], inLeft[1]);
        }
        if (postRight[0] <= postRight[1] && inRight[0] <= inRight[1]) {
            root.right = buildTree(postorder, postRight[0], postRight[1], inorder, inRight[0], inRight[1]);
        }
        return root;
    }

    private int[][] splitInOrder(int[] inorder, int root, int start, int end) {
        int rootIndex = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root) {
                rootIndex = i;
                break;
            }
        }
        return new int[][]{{start, rootIndex - 1}, {rootIndex + 1, end}};
    }
}
