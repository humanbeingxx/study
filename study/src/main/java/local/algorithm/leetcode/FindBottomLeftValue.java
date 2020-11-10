package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode left = null;
        while (!queue.isEmpty()) {
            left = null;
            int size  = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (left == null) {
                    left = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return left.val;
    }
}
