package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxLevel = 1, max = root.val, level = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size= queue.size();
            int currSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                currSum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (currSum > max) {
                max = currSum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}
