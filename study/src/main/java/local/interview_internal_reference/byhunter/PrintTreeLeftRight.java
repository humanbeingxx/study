package local.interview_internal_reference.byhunter;

import com.google.common.collect.Lists;
import local.algorithm.leetcode.common.TreeNode;

import java.util.List;
import java.util.Stack;

public class PrintTreeLeftRight {

    public List<Integer> print(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (root == null) {
            return result;
        }
        boolean fromLeft = true;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                if (fromLeft) {
                    if (pop.left != null) {
                        nextStack.push(pop.left);
                    }
                    if (pop.right != null) {
                        nextStack.push(pop.right);
                    }
                } else {
                    if (pop.right != null) {
                        nextStack.push(pop.right);
                    }
                    if (pop.left != null) {
                        nextStack.push(pop.left);
                    }
                }
            }
            Stack<TreeNode> temp = stack;
            stack = nextStack;
            nextStack = temp;
            fromLeft = !fromLeft;
        }
        return result;
    }
}
