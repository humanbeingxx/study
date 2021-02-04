package local.algorithm.nowcoder.yuanfudao;

import local.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class TraverseNoRec {

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(root);
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> checked = new HashMap<>();
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                checked.put(node, 1);
                node = node.left;
            } else {
                node = stack.peek();
                if (checked.get(node) == 2) {
                    result.add(node.val);
                    stack.pop();
                    node = null;
                } else {
                    checked.put(node, 2);
                    node = node.right;
                }
            }
        }
        return result;
    }
}
