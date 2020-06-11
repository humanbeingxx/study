package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2020-02-24
 **/
public class BuildTreePreIn2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inOrderIndices = buildIndex(inorder);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderIndices);
    }

    private Map<Integer, Integer> buildIndex(int[] inorder) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return indices;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inOrderIndices) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int inOrderRootIndex = inOrderIndices.get(preorder[preStart]);
        int leftNodeNum = inOrderRootIndex - inStart;
        node.left = buildTree(preorder, preStart + 1, preStart + leftNodeNum, inorder, inStart, inOrderRootIndex - 1, inOrderIndices);
        node.right = buildTree(preorder, preStart + leftNodeNum + 1, preEnd, inorder, inOrderRootIndex + 1, inEnd, inOrderIndices);
        return node;
    }

}
