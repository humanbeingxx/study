package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-02-22
 **/
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        putLeft(root);
    }

    private void putLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode ret = stack.pop();
        putLeft(ret.right);
        return ret.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
