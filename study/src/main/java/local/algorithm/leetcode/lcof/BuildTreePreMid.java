package local.algorithm.leetcode.lcof;

import local.algorithm.leetcode.common.TreeNode;

public class BuildTreePreMid {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildRec(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildRec(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart < 0 || preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inOrderRootPos = search(inorder, inStart, inEnd, rootVal);
        int leftTreeLen = inOrderRootPos - inStart, rightTreeLen = inEnd - inOrderRootPos;
        root.left = buildRec(preorder, preStart + 1, preStart + leftTreeLen, inorder, inStart, inOrderRootPos - 1);
        root.right = buildRec(preorder, preEnd - rightTreeLen + 1, preEnd, inorder, inOrderRootPos + 1, inEnd);
        return root;
    }

    private int search(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
