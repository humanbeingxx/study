package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (d > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            d--;
        }
        for (TreeNode node : queue) {
            TreeNode originLeft = node.left;
            TreeNode originRight = node.right;
            TreeNode newNodeLeft = new TreeNode(v);
            TreeNode newNodeRight = new TreeNode(v);
            node.left = newNodeLeft;
            node.right = newNodeRight;
            newNodeLeft.left = originLeft;
            newNodeRight.right = originRight;
        }
        return root;
    }
}
