package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-24
 **/
public class BuildTreePreIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preorder.length || preEnd >= preorder.length || preStart < 0 || preEnd < 0) {
            return null;
        }
        if (inStart >= inorder.length || inEnd >= inorder.length || inStart < 0 || inEnd < 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int[][] split = splitInOrder(inorder, preorder[preStart], inStart, inEnd);
        int[] inLeft = split[0];
        int[] inRight = split[1];
        int preLeftLen = inLeft[1] - inLeft[0] + 1;
        int[] preLeft = new int[]{preStart + 1, preStart + preLeftLen};
        int[] preRight = new int[]{preStart + preLeftLen + 1, preEnd};
        if (preLeft[0] <= preLeft[1] && inLeft[0] <= inLeft[1]) {
            root.left = buildTree(preorder, preLeft[0], preLeft[1], inorder, inLeft[0], inLeft[1]);
        }
        if (preRight[0] <= preRight[1] && inRight[0] <= inRight[1]) {
            root.right = buildTree(preorder, preRight[0], preRight[1], inorder, inRight[0], inRight[1]);
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
