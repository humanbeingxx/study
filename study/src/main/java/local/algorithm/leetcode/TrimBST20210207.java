package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class TrimBST20210207 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trimBSTRec(root, low, high);
    }

    private TreeNode trimBSTRec(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val >= low && root.val <= high) {
            root.left = trimBSTRec(root.left, low, high);
            root.right = trimBSTRec(root.right, low, high);
            return root;
        } else if (root.val < low) {
            return trimBSTRec(root.right, low, high);
        } else {
            return trimBSTRec(root.left, low, high);
        }
    }

}
