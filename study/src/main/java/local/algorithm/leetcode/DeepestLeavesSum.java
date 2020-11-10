package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (queue.isEmpty()) {
                return sum;
            } else {
                sum = 0;
            }
        }
    }
}
