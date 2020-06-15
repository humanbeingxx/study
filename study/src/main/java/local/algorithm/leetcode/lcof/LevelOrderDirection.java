package local.algorithm.leetcode.lcof;

import java.util.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/12 16:53
 */
public class LevelOrderDirection {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean l2r = true;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!l2r) {
                Collections.reverse(temp);
            }
            result.add(new ArrayList<>(temp));
            temp.clear();
            l2r = !l2r;
        }
        return result;
    }
}
