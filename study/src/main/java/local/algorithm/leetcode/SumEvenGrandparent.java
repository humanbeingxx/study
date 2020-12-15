package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumEvenGrandparent {

    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.val % 2 == 0) {
                    sum += addGrandchild(poll);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return sum;
    }

    private int addGrandchild(TreeNode node) {
        int sum = 0;
        if (node.left != null) {
            if (node.left.left != null) {
                sum += node.left.left.val;
            }
            if (node.left.right != null) {
                sum += node.left.right.val;
            }
        }
        if (node.right != null) {
            if (node.right.left != null) {
                sum += node.right.left.val;
            }
            if (node.right.right != null) {
                sum += node.right.right.val;
            }
        }
        return sum;
    }
}
