package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class PostOrderTraversal {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }

    private void postOrderRec(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrderRec(root.left, result);
        postOrderRec(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> added = new HashSet<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right == null || added.contains(curr.right)) {
                result.add(curr.val);
                stack.pop();
                added.add(curr);
                curr = null;
            } else {
                curr = curr.right;
            }
        }

        return result;
    }

}
