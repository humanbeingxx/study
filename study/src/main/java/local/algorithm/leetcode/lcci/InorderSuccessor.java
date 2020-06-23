package local.algorithm.leetcode.lcci;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/22 19:46
 */
public class InorderSuccessor {

    private TreeNode pre = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode left = inorderSuccessor(root.left, p);
        if (left != null) {
            return left;
        }
        if (pre == p) {
            return root;
        }
        pre = root;
        return inorderSuccessor(root.right, p);
    }
}
