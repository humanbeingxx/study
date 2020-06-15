package local.algorithm.leetcode.lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/12 17:01
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        collect(root, new ArrayList<>(), 0, sum, result);
        return result;
    }

    private void collect(TreeNode node, List<Integer> currVal, int currSum, int target, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        currVal.add(node.val);
        currSum += node.val;
        if (currSum == target && isLeaf(node)) {
            result.add(new ArrayList<>(currVal));
        }
        if (node.left != null) {
            collect(node.left, currVal, currSum, target, result);
        }
        if (node.right != null) {
            collect(node.right, currVal, currSum, target, result);
        }
        currVal.remove(currVal.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
