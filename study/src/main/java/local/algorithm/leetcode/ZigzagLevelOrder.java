package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-02-19
 **/
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean leftToRight = false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                temp.add(node.val);
                if (leftToRight) {
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                } else {
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                }
            }
            leftToRight = !leftToRight;

            Stack<TreeNode> tempStack = stack;
            stack = nextStack;
            nextStack = tempStack;
            nextStack.clear();

            result.add(new ArrayList<>(temp));
            temp.clear();
        }
        return result;
    }
}
