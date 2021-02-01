package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class TreeNoRec {

    public List<Integer> preorder(TreeNode root) {
        List<Integer> result= new ArrayList<>();
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

    public List<Integer> inorder(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
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

    public List<Integer> postorder(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> sawChildren = new HashMap<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                sawChildren.put(node, 1);
                node = node.left;
            } else {
                node = stack.peek();
                if (sawChildren.get(node) != 2) {
                    sawChildren.put(node, 2);
                    node = node.right;
                } else {
                    result.add(node.val);
                    stack.pop();
                    node = null;
                }
            }
        }
        return result;
    }
}
