package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/28 14:37
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
