package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class FindMostInSearchTree {

    int maxCount = 0;
    int currCount = 0;
    TreeNode preNode = null;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        rec(root);
        int[] ret = new int[result.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }

    private void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        rec(node.left);
        if (preNode == null) {
            preNode = node;
            maxCount = 1;
            currCount = 1;
        } else if (node.val == preNode.val) {
            currCount++;
        } else {
            currCount = 1;
            preNode = node;
        }

        if (currCount > maxCount) {
            maxCount = currCount;
            result.clear();
            result.add(node.val);
        } else if (currCount == maxCount) {
            result.add(node.val);
        }

        rec(node.right);
    }
}
