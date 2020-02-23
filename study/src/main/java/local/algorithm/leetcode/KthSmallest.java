package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-23
 **/
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>(k);
        rec(root, result, k);
        return result.get(result.size() - 1);
    }

    private void rec(TreeNode node, List<Integer> values, int k) {
        if (node == null || values.size() == k) {
            return;
        }
        rec(node.left, values, k);
        if (values.size() == k) {
            return;
        }
        values.add(node.val);
        if (values.size() == k) {
            return;
        }
        rec(node.right, values, k);
    }
}
