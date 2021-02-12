package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SubtreeWithAllDeepest {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        Set<TreeNode> deepest = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                deepest.add(poll);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (!queue.isEmpty()) {
                deepest.clear();
            }
        }
        return findCommonRoot(root, deepest);
    }

    private TreeNode findCommonRoot(TreeNode root, Set<TreeNode> deepest) {
        if (root == null) {
            return null;
        }
        if (deepest.contains(root)) {
            return root;
        }
        TreeNode left = findCommonRoot(root.left, deepest);
        TreeNode right = findCommonRoot(root.right, deepest);
        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }
        return root;
    }
}
