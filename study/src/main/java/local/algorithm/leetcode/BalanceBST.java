package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        return build(inOrder, 0, inOrder.size() - 1);
    }

    private void inOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }

    private TreeNode build(List<Integer> vals, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(vals.get(mid));
        root.left = build(vals, start, mid - 1);
        root.right = build(vals, mid + 1, end);
        return root;
    }
}
