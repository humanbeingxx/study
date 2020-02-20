package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-20
 **/
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int level = countLevel(root);
        if (level < 2) {
            return level;
        }
        int upperLevelCount = (int) Math.pow(2, level - 1) - 1;
        int pathStart = (int) Math.pow(2, level - 2);
        int low = 0, high = (int) Math.pow(2, level - 1), mid = low + (high - low) / 2;
        TreeNode node;
        while (low < high) {
            node = root;
            int pos = pathStart;
            for (int i = 0; i < level - 1; i++, pos >>= 1) {
                if ((mid & pos) == pos) {
                    //1 right
                    node = node.right;
                } else {
                    //0 left
                    node = node.left;
                }
            }
            if (node == null) {
                high = mid;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }
        return upperLevelCount + low;
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            level++;
        }
        return level;
    }
}
