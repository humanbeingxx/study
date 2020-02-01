package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author cuixiaoshuang
 * @date 2020-02-01
 **/
public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int width = 1, maxWidth = 1;
        List<TreeNode> curr = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
            for (TreeNode node : curr) {
                if (node != null) {
                    next.add(node.left);
                    next.add(node.right);
                } else {
                    next.add(null);
                    next.add(null);
                }
            }
            int left = -1, right = -1;
            for (int i = 0; i < next.size(); i++) {
                if (next.get(i) != null) {
                    left = i;
                    break;
                }
            }
            for (int i = next.size() - 1; i >= 0; i--) {
                if (next.get(i) != null) {
                    right = i;
                    break;
                }
            }
            if (left == right) {
                width = 1;
            } else {
                width = right - left + 1;
            }

            if (width > maxWidth) {
                 maxWidth = width;
            }
            if (next.stream().noneMatch(Objects::nonNull)) {
                break;
            }
            curr.clear();
            curr.addAll(next);
            next.clear();
        }
        return maxWidth;
    }
}
