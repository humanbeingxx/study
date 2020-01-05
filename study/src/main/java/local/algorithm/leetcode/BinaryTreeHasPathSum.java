package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 20:55
 */
public class BinaryTreeHasPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return rec(root, sum);
    }

    private boolean rec(TreeNode node, int sum) {
        int sub = sum - node.val;
        if (sub == 0 && node.left == null && node.right == null) {
            return true;
        }
        boolean checkLeft, checkRight;
        if (node.left != null) {
            checkLeft = rec(node.left, sub);
            if (checkLeft) {
                return true;
            }
        }
        if (node.right != null) {
            checkRight = rec(node.right, sub);
            return checkRight;
        }

        return false;
    }
}
