package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class IterInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

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
}
