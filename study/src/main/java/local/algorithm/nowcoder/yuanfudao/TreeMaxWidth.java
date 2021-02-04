package local.algorithm.nowcoder.yuanfudao;

import local.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

    public int maxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int width = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                    width++;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    width++;
                }
            }
            max = Math.max(max, width);
        }
        return max;
    }
}
