package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderBottom20210222 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        while (!levelNodes.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> levelVal = new ArrayList<>();
            for (TreeNode node : levelNodes) {
                levelVal.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            levelNodes = nextLevel;
            result.add(levelVal);
        }
        Collections.reverse(result);
        return result;
    }
}
