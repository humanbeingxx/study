package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class CousinsInTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        List<TreeNode> pre = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();

        pre.add(root);
        while (!pre.isEmpty()) {
            boolean hasX = false, hasY = false;
            for (TreeNode node : pre) {
                if (node.left == null && node.right == null) {
                    continue;
                } else if (node.right == null) {
                    if (node.left.val == x) {
                        hasX = true;
                    } else if (node.left.val == y) {
                        hasY = true;
                    }
                    if (hasX && hasY) {
                        return true;
                    }
                    curr.add(node.left);
                } else if (node.left == null) {
                    if (node.right.val == x) {
                        hasX = true;
                    } else if (node.right.val == y) {
                        hasY = true;
                    }
                    if (hasX && hasY) {
                        return true;
                    }
                    curr.add(node.right);
                } else {
                    if ((node.left.val == x && node.right.val == y)
                            || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                    if (node.left.val == x || node.right.val == x) {
                        hasX = true;
                    }
                    if (node.left.val == y || node.right.val == y) {
                        hasY = true;
                    }
                    if (hasX && hasY) {
                        return true;
                    }
                    curr.add(node.left);
                    curr.add(node.right);
                }
            }
            List<TreeNode> temp = pre;
            pre = curr;
            curr = temp;
            curr.clear();
        }
        return false;
    }
}
