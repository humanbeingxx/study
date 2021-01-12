package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        boolean evenLevel = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int preValue = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (evenLevel) {
                    if (poll.val % 2 == 0) {
                        return false;
                    }
                    if (preValue >= poll.val) {
                        return false;
                    }
                    preValue = poll.val;
                } else {
                    if (poll.val % 2 != 0) {
                        return false;
                    }
                    if (preValue < poll.val) {
                        return false;
                    }
                    preValue = poll.val;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            evenLevel = !evenLevel;
        }
        return true;
    }
}
