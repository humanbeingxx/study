package local.algorithm.leetcode;

import static local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/12 21:11
 */
public class DeleteBSTNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root.right;
            return root.left;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            root.right = deleteNode(root.right, key);
            return root;
        }
    }

}
