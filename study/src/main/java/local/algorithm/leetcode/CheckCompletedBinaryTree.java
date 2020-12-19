package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletedBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean missed = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (missed && (poll.left != null || poll.right != null)) {
                    return false;
                }
                if (poll.left == null) {
                    missed = true;
                } else {
                    queue.add(poll.left);
                }
                if (poll.right == null) {
                    missed = true;
                } else {
                    if (missed) {
                        return false;
                    }
                    queue.add(poll.right);
                }
            }

        }
        return true;
    }
}
