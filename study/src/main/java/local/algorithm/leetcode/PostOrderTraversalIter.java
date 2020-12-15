package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class PostOrderTraversalIter {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> checked = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (checked.contains(pop) || (pop.left == null && pop.right == null)) {
                result.add(pop.val);
            } else {
                checked.add(pop);
                stack.push(pop);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
        return result;
    }
}
