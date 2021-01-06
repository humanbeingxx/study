package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2020-02-04
 **/
public class DelTreeNodes {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete) {
            toDelete.add(i);
        }
        List<TreeNode> forest = new ArrayList<>();
        del(root, toDelete, forest, true);
        return forest;
    }

    private void del(TreeNode node, Set<Integer> toDelete, List<TreeNode> forest, boolean isCut) {
        if (node == null) {
            return;
        }
        if (toDelete.contains(node.val)) {
            del(node.left, toDelete, forest, true);
            del(node.right, toDelete, forest, true);
        } else {
            if (node.left != null && toDelete.contains(node.left.val)) {
                del(node.left, toDelete, forest, true);
                node.left = null;
            } else {
                del(node.left, toDelete, forest, false);
            }
            if (node.right != null && toDelete.contains(node.right.val)) {
                del(node.right, toDelete, forest, true);
                node.right = null;
            } else {
                del(node.right, toDelete, forest, false);
            }
            if (isCut) {
                forest.add(node);
            }
        }
    }
}
