package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class PostTraversalByIter {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> saw = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek();
            if ((currentNode.left == null && currentNode.right == null)
                    || saw.contains(currentNode)) {
                result.add(currentNode.val);
                stack.pop();
                continue;
            }
            saw.add(currentNode);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

        }

        return result;
    }
}
