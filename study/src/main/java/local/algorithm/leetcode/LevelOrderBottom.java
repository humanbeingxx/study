package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                levelNodes.add(poll.val);
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
            }
            result.add(levelNodes);
        }
        return reverse(result);
    }

    private List<List<Integer>> reverse(List<List<Integer>> result) {
        List<List<Integer>> reversed = new ArrayList<>(result.size());
        for (int i = result.size() - 1; i >=0; i--) {
            reversed.add(result.get(i));
        }
        return reversed;
    }
}
