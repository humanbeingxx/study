package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class RemoveLeafNodes {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if (left == null) {
            root.left = null;
        }
        if (right == null) {
            root.right = null;
        }
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        } else {
            return root;
        }
    }

}
