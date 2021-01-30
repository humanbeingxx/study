package local.algorithm.leetcode.common;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left) {
        this.val = val;
        this.left = left;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;
        return val == node.val &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderRec(this, result);
        return result;
    }

    private void preOrderRec(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        }
        result.add(root.val);
        preOrderRec(root.left, result);
        preOrderRec(root.right, result);
    }

    public List<Integer> levelOrder() {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    result.add(null);
                } else {
                    result.add(poll.val);
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
        }
        int lastNotNull = result.size() - 1;
        while (lastNotNull >= 0) {
            if (result.get(lastNotNull) != null) {
                break;
            }
            lastNotNull--;
        }
        return result.subList(0, lastNotNull + 1);
    }
}