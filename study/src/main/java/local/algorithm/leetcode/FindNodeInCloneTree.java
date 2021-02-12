package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindNodeInCloneTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        List<TreeNode> originalPreOrder = new ArrayList<>();
        List<TreeNode> clonedPreOrder = new ArrayList<>();
        preOrder(original, originalPreOrder);
        preOrder(cloned, clonedPreOrder);
        for (int i = 0; i < originalPreOrder.size(); i++) {
            if (originalPreOrder.get(i) == target) {
                return clonedPreOrder.get(i);
            }
        }
        return null;
    }

    private void preOrder(TreeNode root, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        result.add(root);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}
