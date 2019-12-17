package local.algorithm.leetcode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class PostTraversalByIter {

    public List<Integer> postorderTraversal(BinaryTreeHasPathSum.TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<BinaryTreeHasPathSum.TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<BinaryTreeHasPathSum.TreeNode> saw = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            BinaryTreeHasPathSum.TreeNode currentNode = stack.peek();
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
